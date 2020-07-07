package com.app.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.mail.Multipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.AdminDaoImpl;
import com.app.pojos.Admin;
import com.app.pojos.Childinfo;
import com.app.pojos.CurrentNeed;

@CrossOrigin(origins="*",allowedHeaders = "*")
@RestController
@RequestMapping("/admin")//It is given to remove the ambigiuty of path
public class AdminController {
	
	@Autowired(required = false)
	private AdminDaoImpl dao;
	
  @RequestMapping(method = RequestMethod.POST,path="/adminlogin")
  public boolean getAuthentication(@RequestBody Admin a)//for admin login
  {
		String email=a.getEmail();
		String password=a.getPassword();
		Admin admin= dao.adminAuthentication(email, password);
		if(admin!=null)
		{
			return true;
		}
		else
			return false;
  }
	
//  @RequestMapping(method = RequestMethod.POST,path = "/adminregister")
//  public String registerAdmin(@RequestBody Admin a) 
//  {
//	  String string=dao.adminRegister(a);
//	  return string;
//  }
	
	
  @RequestMapping(method = RequestMethod.POST,path = "/childregister")//To register Child
  public String registerChild(@RequestBody Childinfo c) 
  {
	  String string=dao.addChild(c);
	  return string;
  }
	
  @RequestMapping(method = RequestMethod.POST,path = "/needregister")//To register the needs
  public ResponseEntity<?> registerCurrentNeed(@RequestParam String name,@RequestParam double quantity,@RequestParam(value = "images", 
  required=false) MultipartFile images ) 
  {
	  try{
		  CurrentNeed cn = new CurrentNeed(name, quantity);
		  if( images != null) {
			  
			  cn.setImages(images.getBytes());
		  }
		  return new ResponseEntity<CurrentNeed>(dao.addCurrentNeed(cn),HttpStatus.OK);
		 
	  }catch (Exception e) {
		  e.printStackTrace();
		  return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	 
	  
  }
  
  
  @DeleteMapping("/delete") 
  public ResponseEntity<?> deleteChildDetails(@RequestParam int child_id)
  {
	  System.out.println("delete user details"+child_id);
	  
	 Childinfo child =dao.getChildInfo(child_id);
	 System.out.println(child);
	 if(child !=null)
	 {
		String commment= dao.deleteChild(child);
		System.out.println(commment);
		return new ResponseEntity<Childinfo>(child,HttpStatus.OK);
	 }
	 
	  return new ResponseEntity<Void>(HttpStatus.OK);
  }
  
  @DeleteMapping("/need/{need_id}") 
  public ResponseEntity<Void> deleteCurrentNeed(@PathVariable int need_id)
  {
	 CurrentNeed need =dao.getCurrentNeed(need_id);
	 if(need !=null)
	 {
		String commment= dao.deleteCurrentNeed(need);
		System.out.println(commment);
	 }
	  return new ResponseEntity<>(HttpStatus.OK);
  }
  
  
  	@PutMapping("/{child_id}")
 	public ResponseEntity<?> updateChild(@RequestParam String name, @PathVariable int child_id)
 	{
 		
 		Childinfo c= dao.getChildInfo(child_id);
 		if(c == null)
 		{
 			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
 		}
 		else {
 			c.setName(name);
 			
 			return new ResponseEntity<Childinfo>(dao.updateChild(c),HttpStatus.OK);	
 		}
 			
 	}
  
	
}
