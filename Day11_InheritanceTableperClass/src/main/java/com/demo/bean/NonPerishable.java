package com.demo.bean;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="NonPerishablee")
public class NonPerishable extends Product {
	private int garentee;

	public NonPerishable() {
		super();
	}

	public NonPerishable(int pid, String pname, int qty,  LocalDate mfg,int garentee) {
		super(pid, pname, qty, mfg);
		this.garentee = garentee;
	}

	public int getGar() {
		return garentee;
	}

	public void setGar(int garentee) {
		this.garentee = garentee;
	}

	@Override
	public String toString() {
		return "NonPerishable [garentee=" + garentee + "]";
	}
	

}
