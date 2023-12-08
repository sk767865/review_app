package com.nagarro.product.community.api.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.product.community.api.dto.JwtRequest;
import com.nagarro.product.community.api.dto.JwtResponse;
import com.nagarro.product.community.api.entity.User;
import com.nagarro.product.community.api.exceptions.ProductCommunityApiException;
import com.nagarro.product.community.api.exceptions.UserNotFoundException;
import com.nagarro.product.community.api.service.JwtUtil;
import com.nagarro.product.community.api.service.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		try {
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		}catch(UserNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not found");
		} catch(ProductCommunityApiException e) {
			e.printStackTrace();
			throw new Exception("Invalid Credentials");
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Exception: " + e.getMessage());
		}
		
		UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch(DisabledException e) {
			throw new Exception("User Disabled " + e.getMessage());
		} catch(BadCredentialsException e) {
			throw new ProductCommunityApiException("Invalid Credentials " + e.getMessage());
		} catch(Exception e) {
			throw new Exception("Exception: " + e.getMessage());
		}
	}
	
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return ((User) this.userDetailsServiceImpl.loadUserByUsername(principal.getName()));
	}
	
}
