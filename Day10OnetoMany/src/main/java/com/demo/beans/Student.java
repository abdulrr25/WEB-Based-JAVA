package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Studentt")
public class Student {
	@Id
	private int sid;
	private String sname;
	private double score;
	@ManyToOne
	private Course cour;
	public Student() {
		super();
	}
	public Student(int sid, String sname, double score, Course cour) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.score = score;
		this.cour = cour;
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Course getCour() {
		return cour;
	}
	public void setCour(Course cour) {
		this.cour = cour;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", score=" + score + "  ]";
	}
	
	
}
