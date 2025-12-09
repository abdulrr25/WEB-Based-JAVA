package com.demo.Day17_SpringBootRestWebService.dto;

public class MyUserDto {
	private String UserName;
	private String Password;
	public MyUserDto() {
		super();
	}
	public MyUserDto(String userName, String password) {
		super();
		UserName = userName;
		Password = password;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "MyUserDto [UserName=" + UserName + ", Password=" + Password + "]";
	}
	
	

}
