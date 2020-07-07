package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.app.dao.ICurrentNeedDao;

import com.app.pojos.CurrentNeed;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class CurrentNeedController {

	@Autowired(required = false)
	private ICurrentNeedDao dao;
	
	
	@RequestMapping(method=RequestMethod.GET,path="/currentneed")
	
	public List<CurrentNeed> PerformLogin(){                 //To get the list of current need
		
		
		
		List<CurrentNeed> list = dao.getAllCurrentNeed();
		/*
		 * if (list != null) { return true; }
		 */
		return list;
	}
	
}