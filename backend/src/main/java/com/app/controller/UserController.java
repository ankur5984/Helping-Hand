package com.app.controller;

import javax.annotation.PostConstruct;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

import com.app.pojos.User1;
import com.app.service.IUserService;

@CrossOrigin(origins="*",allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService service;
	@Autowired
	public JavaMailSender javaMailSender;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}
	

	
	
	@GetMapping(value="/sendEmail")
	public String sendmail(String pass) {                        //Used to send mail
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo("spatil3696@gmail.com");
		message.setSubject("SpringBootApplication");
		message.setText("Hi,How are you"+pass);
		
		javaMailSender.send(message);
	
		return"Succesfully send email";
	}
	
	
	@RequestMapping(method=RequestMethod.GET,path="/resetpass")
	public String performCheckPassword(@RequestParam String email ) {      //Used to check password
		System.out.println(email);
		User1 em = service.getPassword(email);
		//System.out.println(em);
		if(em != null)
			return sendmail(em.getPassword());
	
		return "not found";
		
		
	}

	
	@RequestMapping(method=RequestMethod.POST,path="/register")         
	public boolean registerUser(@RequestBody User1 u)                    //To register user
	{
		String str;
		str=service.registerService(u);
		
		if(str!=null) {return true;}
		return false;
		
	}
	@RequestMapping(method=RequestMethod.POST,path="/login")             
	public ResponseEntity<?> PerformLogin(@RequestBody User1 u1){        //To login the user
		System.out.println(u1);
		String email= u1.getEmail();
		String pass=u1.getPassword();   
		User1 u = service.authenticationService(email, pass);
		if(u != null)
		{
			return new ResponseEntity<User1>(u,HttpStatus.OK); 
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
//	@RequestMapping(method=RequestMethod.PUT,path="/update")
	@PutMapping("/{user_id}")
	public ResponseEntity<?> updateUser(@RequestParam String name,@RequestParam String address, @PathVariable int user_id)   //Update user
	{
		System.out.println("in update user"+user_id+name+address);
		User1 u= service.getDetails(user_id);
		if(u == null)
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else {
			u.setName(name);
			u.setAddress(address);
			return new ResponseEntity<User1>(service.updateService(u),HttpStatus.OK);	
		}
			
	}
	
	
	  @DeleteMapping("/{user_id}")                                                 //Delete user
	  
	  public ResponseEntity<Void> deleteUserDetails(@PathVariable int user_id)
	  {
		  System.out.println("delete user details"+user_id);
		  
		  service.deleteService(user_id);
		  return new ResponseEntity<>(HttpStatus.OK);
	  
	  }
	 
	
}
