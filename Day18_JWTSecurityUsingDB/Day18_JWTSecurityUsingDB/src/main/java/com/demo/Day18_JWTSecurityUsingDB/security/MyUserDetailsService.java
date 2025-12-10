package com.demo.Day18_JWTSecurityUsingDB.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.demo.Day18_JWTSecurityUsingDB.beans.MyUser;
import com.demo.Day18_JWTSecurityUsingDB.dao.LoginDao;

public class MyUserDetailsService {

	private LoginDao repo;
	public UserDetails loadUserByUsername(String username) {
		MyUser u=repo.findByUname(username);
		System.out.println("In LoadByUsername");
		System.out.println(u);
		if(u==null) {
            throw new UsernameNotFoundException("User Not Found");

		}
		
		return  org.springframework.security.core.userdetails.User
                .withUsername(u.getUname())
                .password(u.getPassword())
                .roles(u.getRole())  
                .build();
	}

}
