import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from "@angular/router";
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm = new FormGroup({
    username: new FormControl("", [Validators.required, Validators.pattern('^[a-zA-Z]+([0-9]*)$'),Validators.minLength(3)]),
    password: new FormControl("",[Validators.required, Validators.minLength(3),Validators.pattern('[a-zA-Z0-9!@#$%^&*]+')])
  });

  constructor(private loginService: LoginService, private _snack: MatSnackBar, private router: Router) { }

  ngOnInit(): void {
  }

  formSubmit(){
    if (this.loginForm.valid) {
      this.loginService.generateToken(this.loginForm.value).subscribe(
        (data:any) => {
          this.loginService.loginUser(data.token);

          this.loginService.getCurrentUser().subscribe(
            (user:any) => {
              this.loginService.setUser(user);
              this.router.navigate(["/"]);
            }
          );
        },
        (error) => {
          this._snack.open('Invalid Username/Password', 'OK', {
            duration: 3000
          });
        }
      );
    }
  }

  get username(){
    return this.loginForm.get('username');
  }

  get password(){
    return this.loginForm.get('password');
  }

}
