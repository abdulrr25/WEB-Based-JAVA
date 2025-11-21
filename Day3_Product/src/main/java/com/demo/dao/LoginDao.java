package com.demo.dao;

import com.demo.beans.MyUser;

public interface LoginDao {

	MyUser checkUserName(String uname, String pass);

}
