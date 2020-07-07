package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.pojos.CurrentNeed;

@Repository
public class CurrentNeedDaoImpl implements ICurrentNeedDao{

	@PersistenceContext
	private EntityManager mgr;
	@Override
	public List<CurrentNeed> getAllCurrentNeed() {
		String jpql = "select c from CurrentNeed c";
		return mgr.unwrap(Session.class).createQuery(jpql,CurrentNeed.class).getResultList();
	}
	

	
}
