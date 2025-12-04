package com.demo.bean;

public class MyUser {
	private int uid;
	private String uname;
	private String email;
	private Address addr;
	public MyUser() {
		super();
		System.out.println("In default Constructor of MyUser");
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", uname=" + uname + ", email=" + email + ", addr=" + addr + "]";
	}
	
	
	
	
	
}
