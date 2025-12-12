package com.dom.SpringbootRestWebService.dto;

public class MyUserDto {
	
	private String uname;
	private String password;
	public MyUserDto() {
		super();
	}
	public MyUserDto(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "MyUserDto [uname=" + uname + ", password=" + password + "]";
	}
	
	

}
