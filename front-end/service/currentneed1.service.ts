import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class Currentneed1Service {

  constructor(public http:HttpClient) { }

  getList(){
    return this.http.get("http://localhost:8080/test/currentneed").toPromise();
  }
}
