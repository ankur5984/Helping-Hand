package com.app.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.hibernate.Session;

import org.springframework.stereotype.Repository;

import com.app.pojos.Childinfo;

@Repository
public class ChildInfoImpl implements IChildInfoDao{

	
	@PersistenceContext
	private EntityManager mgr;
	@Override
	public List<Childinfo> getChildInfo() {
		String jpql = "select c from  Childinfo c";
		return mgr.unwrap(Session.class).createQuery(jpql,Childinfo.class).getResultList();
	}
}
