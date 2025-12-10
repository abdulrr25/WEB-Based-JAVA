package com.demo.Day18_JWTSecurityUsingDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Day18_JWTSecurityUsingDB.dto.MyUserDto;
import com.demo.Day18_JWTSecurityUsingDB.security.JwtUtil;
import com.demo.Day18_JWTSecurityUsingDB.security.MyUserDetailsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired 
	private AuthenticationManager authManager;
    @Autowired 
    private JwtUtil jwtUtil;
    @Autowired 
    private MyUserDetailsService userDetailsService1;
	
	private MyUserDetailsService userDetailsService;
	
	public ResponseEntity<String> authenticateUser(@RequestBody MyUserDto req){
		System.out.println("In Login Controller");
		System.out.println(req);
		Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
        );
        UserDetails userDetails = userDetailsService1.loadUserByUsername(req.getUsername());
        String token = JwtUtil.generateToken(userDetails); 
        return ResponseEntity.ok(token);
		}
}
