package com.app.service;

import com.app.pojos.Volunteer_Details;

public interface IVolunteerService {

	Volunteer_Details AuthenticateVolunteer(String email,String password);
	String RegisterVolunteer(Volunteer_Details volunteer);
	Volunteer_Details updateVolunteer(Volunteer_Details volunteer);
	public String deleteVolunteerDetails(Volunteer_Details v); 
	Volunteer_Details getDetailsById(int volunteerId);


}
