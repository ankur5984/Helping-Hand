package com.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User1;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao dao;

	@Override
	public User1 authenticationService(String email, String pass) {
		
		return dao.authenticateUser(email, pass);
	}

	@Override
	public void deleteService(int user_id) {
		
		User1 u = dao.getUserDetailsById(user_id);
		if(u != null)
		{
			dao.deleteUser(u);
		}
	}

	
	@Override
	public User1 updateService(User1 u) {
		
		return dao.updateUser(u);
	}


	@Override
	public User1 getDetails(int user_id) {
		
		return dao.getUserDetailsById(user_id);
	}


	@Override
	public String registerService(User1 u) {
		
		return dao.registerUser(u);
	}

	@Override
	public User1 getPassword(String email) {
		// TODO Auto-generated method stub
		return dao.getUserPassword(email);
	}
	
	

}
