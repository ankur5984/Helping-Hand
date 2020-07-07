import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class HappinessService {
  baseUrl = 'http://localhost:8080/test/happiness';
  constructor(private http: HttpClient) { }

  AddData(emp) {
    console.log(emp);
   
    const formData = new FormData();
    formData.append('time', emp.time);
    formData.append('location', emp.location);
    formData.append('event', emp.event);

    return this.http.post(this.baseUrl, emp);
  }

}

