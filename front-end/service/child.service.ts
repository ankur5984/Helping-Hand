import { Injectable } from '@angular/core';
import {HttpClient, HttpParams, HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ChildService {

  constructor(private http1:HttpClient) {

  }

  childlist()
  {


  return this.http1.get("http://localhost:8080/test/childinfo");
  }
  createBasicAutHttpHeader()
  {
    let username='user';
    let password='6d6abd12-a554-4acb-b2c1-54e7c1f8d4f1';
    let basicAuthHeaderString='Basic'+ window.btoa( username+ ':'+ password);
    return basicAuthHeaderString;
  }
}
