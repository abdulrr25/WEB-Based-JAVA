package com.demo.beans;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Coursee")
public class Course {
	
	@Id
	private int cid;
	private String cname;
	private String duration;
	@OneToMany
	Set<Student> eset;
	public Course() {
		super();
	}
	
	
	public Course(int cid, String cname, String duration) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.duration = duration;
	}


	public Course(int cid, String cname, String duration, Set<Student> eset) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.duration = duration;
		this.eset = eset;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Set<Student> getEset() {
		return eset;
	}
	public void setEset(Set<Student> eset) {
		this.eset = eset;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", duration=" + duration + ", eset=" + eset + "]";
	}
	
	
	
}
