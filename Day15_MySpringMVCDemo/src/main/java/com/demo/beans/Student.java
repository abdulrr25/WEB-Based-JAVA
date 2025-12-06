package com.demo.beans;

public class Student {
	private int sid;
	private String sname;
	private String email;
	private String address;
	private double percentage;
	public Student() {
		super();
	}
	public Student(int sid, String sname, String email, double percentage, String address) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.email = email;
		this.percentage = percentage;
		this.address = address;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", email=" + email + ", address=" + address
				+ ", percentage=" + percentage + "]";
	}
	
	
}
