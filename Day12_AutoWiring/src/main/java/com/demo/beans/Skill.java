package com.demo.beans;

public class Skill {
	private int skill;
	private String skname;
	private int experience;
	public Skill() {
		super();
		System.out.println("In Default Constructor of Skill");
	}
	public Skill(int skill, String skname, int experience) {
		super();
		this.skill = skill;
		this.skname = skname;
		this.experience = experience;
	}
	public int getSkill() {
		return skill;
	}
	public void setSkill(int skill) {
		this.skill = skill;
	}
	public String getSkname() {
		return skname;
	}
	public void setSkname(String skname) {
		this.skname = skname;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	@Override
	public String toString() {
		return "Skill [skill=" + skill + ", skname=" + skname + ", experience=" + experience + "]";
	}
	
	
	
}
