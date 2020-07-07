package com.app.dao;

import com.app.pojos.User1;
import com.app.pojos.Volunteer_Details;

public interface IVolunteerDao
	{
	Volunteer_Details authenticateVolunteer(String username,String password);
	String registerVolunteer(Volunteer_Details volunteer);
	 Volunteer_Details updateVolunteer(Volunteer_Details v);	
	String deleteVolunteerDetails(Volunteer_Details v); 	
	public Volunteer_Details getVolunteerDetailsById(int user_id);
	}


