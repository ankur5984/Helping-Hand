package com.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.User1;

@Repository
public class UserDaoImpl implements IUserDao {
	
	@PersistenceContext
	private EntityManager mgr;

	@Override
	public User1 authenticateUser(String email, String pwd) {
		System.out.println(email+pwd);
		try {
			String jpql = "select u from User1 u where u.email = :em and u.password=:pass";
			System.out.println("in authenticateuser s");
		
		return mgr.unwrap(Session.class).createQuery(jpql, User1.class).setParameter("em", email).
				setParameter("pass", pwd)
				.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

	@Override
	public String registerUser(User1 u) {
		
		mgr.unwrap(Session.class).persist(u);
		return "User with ID "+u.getUserId()+" registered successfully";
	}

	
	@Override
	public String deleteUser(User1 u) {
		
		String mesg = "User deletion failed....";
		
	
			mgr.unwrap(Session.class).delete(u);
		
		return mesg;
	}

	@Override
	public User1 updateUser(User1 u) {
		mgr.unwrap(Session.class).update(u);
		return u;
	}

	@Override
	public User1 getUserDetailsById(int user_id) {
		
		return mgr.unwrap(Session.class).get(User1.class,user_id);
		 
	}

	@Override
	public User1 getUserPassword(String email) {
		
		System.out.println(email);
		try {
			String jpql = "select u from User1 u where u.email = :em ";
			System.out.println("in authenticateuser s");
		
		return mgr.unwrap(Session.class).createQuery(jpql, User1.class).setParameter("em", email)
				.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	
	
	

}
