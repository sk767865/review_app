import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../models/Login';
import { Subject } from 'rxjs';
import rootUrl from './properties';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public userUpdated = new Subject<any>();

  constructor(private http:HttpClient) { }

  public generateToken(loginData:Login){
    return this.http.post(`${rootUrl}/generate-token`, loginData);
  }

  public loginUser(token:string){
    localStorage.setItem('token', token);
    return true;
  }

  public setUser(user:any){
    localStorage.setItem('user', JSON.stringify(user));
    this.userUpdated.next(this.getUser());
    return true;
  }

  public isLoggedIn(){
    let token = localStorage.getItem('token');
    if(token == undefined || token == '' || token == null){
      return false;
    }
    return true;
  }

  public isAdmin(){
    let userRoles = this.getUserRoles();
    let isAdmin = false;
    if(userRoles != null){
      userRoles.forEach(
        (element:any) => {
        if(element.authority == "ADMIN"){
          isAdmin =  true;
        }
      });
    } 
    return isAdmin;
  }

  public isUser(){
    let userRoles = this.getUserRoles();
    let isUser = false;
    if(userRoles != null){
      userRoles.forEach(
        (element:any) => {
        if(element.authority == 'USER'){
          isUser = true;
        }
      });
    }
    return isUser;
  }

  public logout(){
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    this.userUpdated.next(null);
    return true;
  }

  public getToken(){
    return localStorage.getItem('token');
  }

  public getUser(){
    let user = localStorage.getItem('user');
    if(user != null){
      return JSON.parse(user);
    } else{
       //this.logout();
      return null;
    }
  }

  public getUserRoles(){
    let user:any = this.getUser();
    if(user != null){
      return user.authorities;
    }
    return null;
  }

  public getCurrentUser(){
    return this.http.get(`${rootUrl}/current-user`);
  }

}
