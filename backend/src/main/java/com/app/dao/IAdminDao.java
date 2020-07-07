package com.app.dao;

import com.app.pojos.Admin;
import com.app.pojos.Childinfo;
import com.app.pojos.CurrentNeed;

public interface IAdminDao {

	Admin adminAuthentication(String email,String password);
//	String adminRegister(Admin a);
	String addChild(Childinfo c);
	String deleteChild(Childinfo c);
	Childinfo getChildInfo(int id);
	Childinfo updateChild(Childinfo c);
	CurrentNeed addCurrentNeed(CurrentNeed cn);
	String deleteCurrentNeed(CurrentNeed cn);
	CurrentNeed getCurrentNeed(int id);
}
