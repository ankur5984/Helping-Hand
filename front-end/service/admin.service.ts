import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor( private http:HttpClient) { 




  }


childDelete(id)
{

  let params1=new HttpParams().set('child_id',id);
  return  this.http.delete("http://localhost:8080/test/admin/delete",{params:params1});
}
}
