package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IVolunteerDao;
import com.app.pojos.Volunteer_Details;
@Service
@Transactional
public class VolunteerServiceImpl implements IVolunteerService {

	@Autowired
	IVolunteerDao dao;
	
	
	@Override
	public Volunteer_Details AuthenticateVolunteer(String email, String password) {
		return dao.authenticateVolunteer(email, password);
		

	}

	@Override
	public String RegisterVolunteer(Volunteer_Details volunteer) {
		return dao.registerVolunteer(volunteer);
		 
	}

	@Override
	public Volunteer_Details updateVolunteer(Volunteer_Details volunteer) {
		return dao.updateVolunteer(volunteer);
	}

	@Override
	public String deleteVolunteerDetails(Volunteer_Details v ) {
		return dao.deleteVolunteerDetails(v);
		
	}

	@Override
	public Volunteer_Details getDetailsById(int volunteerId) {
		
		return dao.getVolunteerDetailsById(volunteerId);
	}

}
