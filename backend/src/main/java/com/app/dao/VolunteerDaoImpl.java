package com.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.User1;
import com.app.pojos.Volunteer_Details;

@Repository
public class VolunteerDaoImpl implements IVolunteerDao {

	@PersistenceContext
	private EntityManager mgr;
	
	@Override
	public Volunteer_Details authenticateVolunteer(String email, String password) {
		try {
			String jpql = "select u from Volunteer_Details u where u.email = :em and u.password=:pass";
			System.out.println("in authenticateuser s");
		
		return mgr.unwrap(Session.class).createQuery(jpql, Volunteer_Details.class).setParameter("em", email).
				setParameter("pass", password)
				.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}

	@Override
	public String registerVolunteer(Volunteer_Details volunteer) {
		System.out.println("In Dao"+volunteer);
		mgr.unwrap(Session.class).persist(volunteer);
		return "User with ID "+volunteer.getVolunteerId()+" registered successfully";
	
	}

	@Override
	public Volunteer_Details updateVolunteer(Volunteer_Details v) {
		mgr.unwrap(Session.class).update(v);
		return v;

		

	}

	@Override
	public String deleteVolunteerDetails(Volunteer_Details v) {
		String mesg = "User deletion failed....";
		
		
		mgr.unwrap(Session.class).delete(v);
	
	return mesg;

	}
	
	@Override
	public Volunteer_Details getVolunteerDetailsById(int volunteer_id) {
		
		return mgr.unwrap(Session.class).get(Volunteer_Details.class,volunteer_id);
		 
	}
	

}
