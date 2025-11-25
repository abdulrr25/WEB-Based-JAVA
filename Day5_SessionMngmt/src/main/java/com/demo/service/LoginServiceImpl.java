package com.demo.service;

import com.demo.bean.MyUser;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService{

	private LoginDao ldao;
	
	public LoginServiceImpl() {
		ldao=new LoginDaoImpl();
	}

	@Override
	public MyUser validateuser(String uname,String pass) {
		// TODO Auto-generated method stub
		return ldao.validateuser(uname,pass);
	}
}
