package com.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.pojos.MoneySupport;



@Repository
public class MoneySupportDaoImpl implements IMoneySupportDao {
	
	@PersistenceContext
	EntityManager mgr;
	
	@Override
	public String addMoney(MoneySupport m) {
		
		mgr.unwrap(Session.class).persist(m);
		return "Money with ID "+m.getMoneyId()+" added successfully";
	}
	
}
