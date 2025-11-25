package com.demo.dao;

import com.demo.bean.MyUser;

public interface LoginDao {

	MyUser validateuser(String uname, String pass);

}
