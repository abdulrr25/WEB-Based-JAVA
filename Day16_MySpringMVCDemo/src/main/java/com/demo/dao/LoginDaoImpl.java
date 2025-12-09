package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.MyUser;
@Repository
public class LoginDaoImpl implements LoginDao{
	@Autowired
	JdbcTemplate jdbctemplate;
	public MyUser validateUser(String uname, String passwrd) {
		// TODO Auto-generated method stub
		try {
			MyUser u1 = jdbctemplate.queryForObject("Select * from user where uname=? and passwrd=?", new Object[] {uname,passwrd},BeanPropertyRowMapper.newInstance(MyUser.class));
			System.out.println(u1);
			
			return u1;
		} catch(EmptyResultDataAccessException e) {
			System.out.println("user not found");
			return null;
		}
		
		
	}

}
