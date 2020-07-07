package com.app.dao;

import com.app.pojos.User1;

public interface IUserDao {
	
	User1 authenticateUser(String email,String pwd);
	
	String registerUser(User1 u);
	
	String deleteUser(User1 u);
	
	User1 updateUser(User1 u);
	
	User1 getUserDetailsById(int user_id);
	
	User1 getUserPassword(String email);
}
