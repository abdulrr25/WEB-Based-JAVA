package com.demo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyUser {
	@Value("Rajeev")
	private String name;

	public MyUser() {
		super();
	}
	public MyUser(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		System.out.println("In getter method Of myuser");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		System.out.println("In To String method of myuser");
		return "MyUser [name=" + name + "]";
	}
	
	public void m1() {
		System.out.println("in m1 method");
	}
	
	public int m2(int x) {
		System.out.println("in m2 method "+x);
		return x+10;
	}


}
