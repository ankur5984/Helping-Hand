package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.app.dao.IPayamentGatewayDao;
import com.app.pojos.Childinfo;
import com.app.pojos.PaymentGateway;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class PaymentGatewayController {
	
	
	@Autowired
	private IPayamentGatewayDao dao;
	
	
	@RequestMapping(method=RequestMethod.POST,path="/paymentgateway")
	public boolean paymentGateway(@RequestBody PaymentGateway p){	
		System.out.println(p);
		String str= dao.paymentGateway(p);
		
		if(str != null)
			{
				return true;
			}
		
		return false;
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/getpayment")
	public ResponseEntity<PaymentGateway> get()
	{
	
		PaymentGateway pay= new PaymentGateway();
		pay.setAmount(1000);
		pay.setDescription("humanity");
		pay.setUserId(1);
	//	System.out.println(pay);
		return new ResponseEntity<PaymentGateway>(pay,HttpStatus.OK);
	}
}
