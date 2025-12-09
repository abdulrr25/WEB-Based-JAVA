package com.demo.beans;

public class MyUser {
	private String uname;
	private String passwrd;
	private String role;
	public MyUser() {
		super();
	}
	public MyUser(String uname, String passwrd, String role) {
		super();
		this.uname = uname;
		this.passwrd = passwrd;
		this.role = role;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPasswrd() {
		return passwrd;
	}
	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "MyUser [uname=" + uname + ", passwrd=" + passwrd + ", role=" + role + "]";
	}
	
	
}
