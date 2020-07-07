package com.app.dao;

import java.util.List;

import com.app.pojos.Neccessity_support;
import com.app.pojos.Volunteer_Details;

public interface INeccessityDao 
{
	//Neccessity_support authenticateNeccessity(String name,String password);
	//List<Neccessity_support> getAllNecessity();
	String registerNeccessity(Neccessity_support n);
	Neccessity_support updatedDetails(Neccessity_support n);	
	String deleteNeccessity(Neccessity_support n); 	
	public Neccessity_support getNeccessityById(int neccessity_id);
}
