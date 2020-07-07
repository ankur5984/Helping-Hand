import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ChildregisterService {

  constructor(public http:HttpClient) { }

  addChild(admin,images){
    const formData = new FormData();
    formData.append("name",admin.name);
    formData.append("quantity",admin.quantity);
    formData.append("images",images);
 
    return this.http.post("http://localhost:8080/test/admin/needregister",formData);

  }
}
