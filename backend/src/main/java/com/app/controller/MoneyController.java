package com.app.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.MoneySupport;
import com.app.service.IMoneyService;


@CrossOrigin(origins="*",allowedHeaders = "*")
@RestController
public class MoneyController {

	@Autowired
	private IMoneyService service;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/moneysupport")
	public boolean addMoneyController(@RequestBody MoneySupport m)  //To give moneysupport
	{
		System.out.println(m);
		String str= service.moneyService(m);
	
		if(str != null)
		{
			return true;
		}
		return false;
	}
	
	
	
	
}
