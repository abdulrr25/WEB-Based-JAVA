package com.demo.services;

import com.demo.beans.MyUser;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServicesImpl implements LoginService {

	
	private LoginDao Ldao;
	
	
	public LoginServicesImpl() {
		super();
		Ldao = new LoginDaoImpl();
	}


	@Override
	public MyUser validateUser(String uname, String pass) {
		// TODO Auto-generated method stub
		return Ldao.checkUserName(uname,pass);
	}

}
