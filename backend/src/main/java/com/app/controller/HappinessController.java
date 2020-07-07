package com.app.controller;





import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IHappinessSupportDao;
import com.app.pojos.Hapiness_Support;


@CrossOrigin(origins="*",allowedHeaders = "*")
@RestController
public class HappinessController {

	@Autowired
	private IHappinessSupportDao dao;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + dao);
	}
	
	/*
	 * @RequestMapping(method=RequestMethod.POST,value="/happiness") public boolean
	 * addLocationController(@RequestBody Hapiness_Support m) { String str=
	 * service.registerVenue(m); if(str != null) { return true; } return false; }
	 */
	

	//@RequestMapping(method=RequestMethod.POST,value="/happiness",consumes = "application/json", produces = "application/json")
	
	@RequestMapping(value="/happiness",method = RequestMethod.POST)
	@ResponseBody
	public boolean addLocationController(@RequestBody Hapiness_Support hs)
	{
		String str1;
		System.out.println(hs);
		str1 = dao.registerLocation(hs);
		if(str1 != null)
		{
			return true;
			
		}
		return false;
	}
	
	@RequestMapping(value="/getHappiness",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Hapiness_Support> get()
	{
		
		Hapiness_Support hs=new Hapiness_Support();
		hs.setLocation("Lucknow");
		hs.setNgo_id(10);
		
		hs.setUser_id(100);
		 return new ResponseEntity<Hapiness_Support>(hs,HttpStatus.OK) ;
	}
	
}
