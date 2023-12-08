import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  firstName:string='';
  lastName:string='';
  constructor(public loginService:LoginService, private router:Router) { }

  ngOnInit(): void {
    if(this.loginService.getUser()!==null){
    this.firstName = this.loginService.getUser().firstName;
    this.lastName = this.loginService.getUser().lastName;
    }
    
    this.loginService.userUpdated.asObservable().subscribe(
      (user) => {
        if(user!=null){
          this.firstName = user.firstName;
          this.lastName = user.lastName;
        }
      }
    );
  }

  public logout(){
    this.loginService.logout();
    this.router.navigate(['/']);
  }

}
