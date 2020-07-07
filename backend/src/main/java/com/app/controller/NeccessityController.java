package com.app.controller;



import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.INeccessityDao;
import com.app.pojos.Neccessity_support;
import com.app.service.INeccessityService;



@CrossOrigin(origins ="*",allowedHeaders = "*")
@RestController
@RequestMapping("/necessity")
public class NeccessityController 
{

	 @Autowired
	 public INeccessityService service;
	 public INeccessityDao dao;
	 @PostConstruct
		public void init() {
			System.out.println("in init " + service);
		}
	 
	 @RequestMapping(method=RequestMethod.POST,value="/necessity" )
	public boolean registerNeccessity(@RequestBody Neccessity_support ns)//To register the necessity
	{   
		 System.out.println(ns);
		String str=service.registerNeccessity(ns);
		if(str==null)
		{
			return false;
		}
		return true;
	}
		
	 @PutMapping("/{necc_id}")
	 public ResponseEntity<?>updateNeccessity(@PathVariable int necc_id,@RequestParam String neccessity,@RequestParam int qty )
	 {
		 Neccessity_support ns=service.getNeccessityById(necc_id);
		 if(ns==null)
		 {
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		 }
		 else
		 {
			ns.setName(neccessity);
			ns.setQuantity(qty);
			return new ResponseEntity<Neccessity_support>(service.updatedDetails(ns),HttpStatus.OK);
		 }
		 
	 }
	 
	 
	 @DeleteMapping("/{necc_id}")
	 public ResponseEntity<Void>deleteNeccessity(@PathVariable int necc_id)
	 {
		 Neccessity_support ns=service.getNeccessityById(necc_id);
		 service.deleteNeccessity(ns);
		
		 return new ResponseEntity<>(HttpStatus.OK);
	 }
//	 
//	 @GetMapping(method = RequestMethod.GET, path = "/necessities")
//	 public List<Neccessity_support> getNecessity(String name)
//	 {
//		List<Neccessity_support> list=new ArrayList<Neccessity_support>();
//		list= dao.getAllNecessity();
//		 return  list;
//	 }
//	 
	 
	 
}
