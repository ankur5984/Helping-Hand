package com.app.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.pojos.Admin;
import com.app.pojos.Childinfo;
import com.app.pojos.CurrentNeed;
import com.app.pojos.User1;

@Repository
@Transactional
public class AdminDaoImpl implements IAdminDao {

	@PersistenceContext
	private EntityManager mgr;
	@Override
	public Admin adminAuthentication(String email, String password) {
		try
		{
		String jpql="Select a from Admin a where a.email= :email and a.password= :password";
		
		
		return mgr.unwrap(Session.class).createQuery(jpql, Admin.class).setParameter("email", email).
				setParameter("password", password).getSingleResult();
				
		}
		
		catch (Exception e) {
			return null;
		}
	}
//	@Override
//	public String adminRegister(Admin a) {
//		
//		System.out.println("asd"+a);
//		mgr.unwrap(Session.class).persist(a);
//		return "hi";
//	}
	
	@Override
	public String addChild(Childinfo c) {
		
		mgr.unwrap(Session.class).persist(c);
		return "Child Registered successfully";
	}
	
	@Override
	public String deleteChild(Childinfo c) {
		
		mgr.unwrap(Session.class).delete(c);
		 return "Child  information deleted successfully";
	}
	
	
	@Override
    public Childinfo getChildInfo(int id) {
		System.out.println(id);
		Childinfo u= mgr.unwrap(Session.class).get(Childinfo.class, id);
		System.out.println(u);
	return u;
	
	}
	
	@Override
	public Childinfo updateChild(Childinfo c) {
		mgr.unwrap(Session.class).update(c);
		return c;
	}
	
	@Override
	public CurrentNeed addCurrentNeed(CurrentNeed cn) {
		// TODO Auto-generated method stub
		 mgr.unwrap(Session.class).persist(cn);
		 return cn;
	//	return "currentneed registered successfully";
	}
	
	
	@Override
	public CurrentNeed getCurrentNeed(int id) {
		// TODO Auto-generated method stub
		return mgr.unwrap(Session.class).get(CurrentNeed.class, id);
	}
	
	@Override
	public String deleteCurrentNeed(CurrentNeed cn) {
		// TODO Auto-generated method stub
		mgr.unwrap(Session.class).delete(cn);
		return "currentNeed information deleted successfully";
	}


	
	
	
	

}
