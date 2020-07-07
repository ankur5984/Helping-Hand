import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http'
import { Observable } from 'rxjs';
import { User } from '../Model/User';
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {



  constructor(
    private http:HttpClient
  ) { }

  loginapi(user:User):any
  {
   
     console.log(user);
    return this.http.post("http://localhost:8080/test/user/login",user);

  }

  signUp(user)
  {
    console.log(user);
    return this.http.post("http://localhost:8080/test/user/register",user);

  }
  isLogin()
  {
let user= sessionStorage.getItem('user');
console.log(user+"hello");
console.log(!(user === null));
  return !(user === null);
  }
  loginapi1(user,password)
  {
    console.log(user+password+"hello");
    let params1=new HttpParams().set('user',user).append('password',password);

   return this.http.post("http://localhost:8080/test/user/login",{params:params1});


  }

  forGet(user: string) {
   console.log(user);
   let params1=new HttpParams().set('email',user)
   return this.http.get("http://localhost:8080/test/user/resetpass",{params:params1});
  }


  Logout() {
  sessionStorage.removeItem('user');
  sessionStorage.removeItem('id');
  }
}

