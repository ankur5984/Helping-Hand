import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PayementService {

  constructor(private http: HttpClient) { }


  payement(payement) {
    console.log(payement);
    return this.http.post('http://localhost:8080/test/paymentgateway', payement);
  }

  AddMoney(money) {

    return this.http.post('http://localhost:8080/test/moneysupport', money);
  }
}
