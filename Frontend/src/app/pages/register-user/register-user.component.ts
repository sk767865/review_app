import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from "@angular/router";
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {

  registerationForm = new FormGroup({
    username: new FormControl("", [Validators.required, Validators.pattern('[a-zA-Z]+')]),
    email: new FormControl("", [Validators.required, Validators.email]),
    firstName: new FormControl("",[Validators.required, Validators.pattern('^[a-zA-Z]+( [a-zA-Z]+)*$'),Validators.minLength(3)]),
    lastName: new FormControl("",[Validators.required, Validators.pattern('^[a-zA-Z]+( [a-zA-Z]+)*$'),Validators.minLength(3)]),
    password: new FormControl("", [Validators.required, Validators.minLength(3),Validators.pattern('[a-zA-Z0-9!@#$%^&*]+')])
  });

  constructor(private userService: UserService, private _snack: MatSnackBar, private router: Router) { }

  ngOnInit(): void {
  }

  formSubmit(){
    if (this.registerationForm.valid) {
      this.userService.addUser(this.registerationForm.value).subscribe(
        (data)=>{
          Swal.fire('Success', 'Registration Successful', 'success');
          this.router.navigate(["/login"]);
        },
        (error)=>{
          this._snack.open('Username Already Exists!', 'OK', {
            duration: 3000
          });
        }
      )
    }
  }

  get username(){
    return this.registerationForm.get('username');
  }

  get email(){
    return this.registerationForm.get('email');
  }

  get password(){
    return this.registerationForm.get('password');
  }

}
