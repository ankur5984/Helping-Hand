import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpParams, HttpHeaders} from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  amount:any;
  constructor(private http:HttpClient, private router: Router,private route: ActivatedRoute) { }

  ngOnInit() {

    this. amount= this.route.snapshot.paramMap.get('amount');
  }


}
