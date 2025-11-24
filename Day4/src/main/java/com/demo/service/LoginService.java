package com.demo.service;

import com.demo.bean.MyUser;

public interface LoginService {

	MyUser validateUSer(String uname, String pass);

	boolean register(MyUser user);

	boolean forgot(String email, String pass);

}
