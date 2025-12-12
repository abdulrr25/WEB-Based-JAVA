package com.dom.SpringbootRestWebService.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MyUser")
public class MyUser {
	@Id
	private int uid;
	private String uname;
	private String role;
	public MyUser() {
		super();
	}
	public MyUser(int uid, String uname, String role) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.role = role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", uname=" + uname + ", role=" + role + "]";
	}
	
	
	

}
