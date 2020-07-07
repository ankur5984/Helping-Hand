package com.app.service;

import org.springframework.stereotype.Service;

import com.app.pojos.Neccessity_support;
@Service
public interface INeccessityService 
{
	String registerNeccessity(Neccessity_support volunteer);
	Neccessity_support updatedDetails(Neccessity_support n);	
	String deleteNeccessity(Neccessity_support n); 	
	public Neccessity_support getNeccessityById(int neccessity_id);
	
}
