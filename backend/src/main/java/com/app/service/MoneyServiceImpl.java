package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IMoneySupportDao;
import com.app.dao.IUserDao;
import com.app.pojos.MoneySupport;
import com.app.pojos.User1;


@Service
@Transactional
public class MoneyServiceImpl implements IMoneyService {

	
	@Autowired
	private IMoneySupportDao dao;
	
	@Override
	public String moneyService(MoneySupport m) {
		
		
		return dao.addMoney(m);
		
	}
	
	

}
