  

package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.INeccessityDao;
import com.app.pojos.Neccessity_support;
@Service
@Transactional
public class NeccessityServiceImpl implements INeccessityService {

	@Autowired
	 public INeccessityDao dao;
	@Override
	public String registerNeccessity(Neccessity_support ns) {
	
		return dao.registerNeccessity(ns);
	}

	@Override
	public Neccessity_support updatedDetails(Neccessity_support ns) {
		// TODO Auto-generated method stub
		return dao.updatedDetails(ns);
	}

	@Override
	public String deleteNeccessity(Neccessity_support ns) {
		// TODO Auto-generated method stub
		return dao.deleteNeccessity(ns);
	}

	@Override
	public Neccessity_support getNeccessityById(int neccessity_id) {
		// TODO Auto-generated method stub
		return dao.getNeccessityById(neccessity_id);
	}

}
