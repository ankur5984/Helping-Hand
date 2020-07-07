package com.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.pojos.PaymentGateway;


@Repository
@Transactional
public class PaymentGatewayDaoImpl implements IPayamentGatewayDao{

	
	@PersistenceContext
	private EntityManager mgr;
	
	@Override
	public String paymentGateway(PaymentGateway p ) {
		System.out.println(p);
		
			mgr.unwrap(Session.class).persist(p);
			return "payment done"+p.getPaymentId()+"successful";
	
	}

}
