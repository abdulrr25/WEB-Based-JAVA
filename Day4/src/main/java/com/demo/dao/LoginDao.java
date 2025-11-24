package com.demo.dao;

import com.demo.bean.MyUser;

public interface LoginDao {

	MyUser checkUser(String uname, String pass);

	boolean register(MyUser user);

	boolean forgot(String email, String pass);

}
