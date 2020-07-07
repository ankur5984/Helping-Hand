package com.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.pojos.Hapiness_Support;



@Repository
@Transactional
public class HappinessSupportDaoImpl implements IHappinessSupportDao {

	@PersistenceContext
	private EntityManager mgr1;
	
	@Override
	public String registerLocation(Hapiness_Support hs) {
		
		mgr1.unwrap(Session.class).persist(hs);
		System.out.println("hs="+hs);
		
		return "Venue with ID "+hs.getH_id()+" added successfully";
	}

	

}
