package com.app.service;

import com.app.pojos.User1;

public interface IUserService {
	User1 authenticationService(String email,String Pass);
	
	String registerService(User1 u);
	
	void deleteService(int user_id);
	
	User1 updateService(User1 u);
	User1 getDetails(int user_id);
	
	User1 getPassword(String email);
}
