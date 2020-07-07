import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class NeccessitysupportService {

  constructor(public http: HttpClient) { }

  AddData(user) {
    const formData = new FormData();
    formData.append('name', user.name);
    formData.append('quantity', user.quantity);
   

    return this.http.post('http://localhost:8080/test/necessity/necessity', user);
  }
}
