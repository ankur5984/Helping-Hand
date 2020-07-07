package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.pojos.Neccessity_support;
@Repository
@Transactional
public class NeccessityImpl implements INeccessityDao {

	@PersistenceContext
	private EntityManager mgr;
	@Override
	public String registerNeccessity(Neccessity_support ns) {
		mgr.unwrap(Session.class).persist(ns);
		return "Neccessity with ID "+ns.getneccessityId()+" registered successfully";
	}

	@Override
	public Neccessity_support updatedDetails(Neccessity_support ns) {
		 mgr.unwrap(Session.class).update(ns);
		 return ns;
	}

	@Override
	public String deleteNeccessity(Neccessity_support ns) {
		
		mgr.unwrap(Session.class).delete(ns);
	
		return  "neccessity  deleted successfully";
	}

	@Override
	public Neccessity_support getNeccessityById(int neccessity_id) {
		return mgr.unwrap(Session.class).get(Neccessity_support.class,neccessity_id);
	}

//	@Override
//	public List<Neccessity_support> getAllNecessity() {
//		System.out.println("love u dao1");
//		String jpql= "select n from Neccessity_support n";
//		System.out.println("love u dao2");
//
//		return  mgr.unwrap(Session.class).createQuery(jpql, Neccessity_support.class).getResultList();
//	}

}
