package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IHappinessSupportDao;
import com.app.pojos.Hapiness_Support;


@Service
public class HappinesSupportService implements IHappinessSupportService{

	@Autowired
	private IHappinessSupportDao dao;
	@Override
	public String registerVenue(Hapiness_Support hs) {
		
		return dao.registerLocation(hs);
	}


}
