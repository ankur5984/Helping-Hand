package com.app.controller;

import java.util.Date;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User1;
import com.app.pojos.Volunteer_Details;
import com.app.service.IVolunteerService;


@CrossOrigin(origins="*",allowedHeaders = "*")
@RestController
public class VolunteerController {
   
	@Autowired
	public IVolunteerService service;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	
	
	/*
	 * @RequestMapping(method=RequestMethod.POST,path="/login") public boolean
	 * PerformLogin(@RequestBody User1 u1){ System.out.println(u1); String email=
	 * u1.getEmail(); String pass=u1.getPassword(); User1 u =
	 * service.authenticationService(email, pass); if(u != null) { return true; }
	 * 
	 * return false; }
	 * 
	 * 
	 */
	

	@RequestMapping(method = RequestMethod.POST, value ="/volunteer")
	public Volunteer_Details loginVolunteer(@RequestBody Volunteer_Details v) {            //login volunteer
		String email = v.getEmail();
		String password = v.getPassword();
		System.out.println("hello Login");
		Volunteer_Details volunteer = service.AuthenticateVolunteer(email, password);
		if (volunteer != null)
			return volunteer;

		return null;
	}
	
	
	
	
	

	@RequestMapping(method = RequestMethod.POST, value = "/volunteer_signup")
	@ResponseBody
	public ResponseEntity<?> registerVolunteer(@RequestBody Volunteer_Details v) {      //register volunteer
		System.out.println(v);
		Volunteer_Details vol = new Volunteer_Details();
		vol.setAddress(v.getAddress());
		vol.setDateOfBirth(v.getDateOfBirth());
		vol.setEmail(v.getEmail());
		vol.setMobileNo(v.getMobileNo());
		vol.setGender(v.getGender());
		vol.setOccupation(v.getOccupation());
		vol.setPassword(v.getPassword());
		vol.setName(v.getName());
		
			
		service.RegisterVolunteer(vol);
		return new ResponseEntity<String>("Registered successfully", HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/get")
	public ResponseEntity<Volunteer_Details> get()
	{
		
	
		Volunteer_Details vol = new Volunteer_Details();
		vol.setAddress("fasdghh");
		//Date d= new Date("2019-09-11");
		//vol.setDateOfBirth(d);
		vol.setEmail("hsdgh");
		vol.setMobileNo("adfshskj");
		vol.setAddress("jdfhksjhf");
		vol.setName("dfgh");
		vol.setOccupation("fdhgf");
		vol.setPassword("hfkdjf");
		
		return new ResponseEntity<Volunteer_Details>(vol,HttpStatus.OK);
	}
	
	
	

	@PutMapping("/{volunteerId}")
	public ResponseEntity<?> updateUser(@RequestParam String name, @RequestParam String address,        //Update volunteer
			@PathVariable int volunteerId) {

		Volunteer_Details v = service.getDetailsById(volunteerId);

		if (v == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			v.setName(name);
			v.setAddress(address);
			return new ResponseEntity<Volunteer_Details>(service.updateVolunteer(v), HttpStatus.OK);
		}

	}
	
	@DeleteMapping("/{volunteerId}")
   public ResponseEntity<?>	deleteVolunteer(@PathVariable int volunteerId )                            //delete volunteer
	{
		Volunteer_Details v = service.getDetailsById(volunteerId);
		if(v==null)
		{
			System.out.println("No such Volunteer with such id  to delete");
		}
		service.deleteVolunteerDetails(v);
		
		System.out.println(" deleted successfully with id"+ volunteerId);
		return  new ResponseEntity<>(HttpStatus.OK);
	}

}
