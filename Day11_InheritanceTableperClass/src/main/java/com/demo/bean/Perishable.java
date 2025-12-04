package com.demo.bean;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="Perishablee")
public class Perishable extends Product {
	
	private LocalDate expdate;

	public Perishable() {
		super();
	}

	public Perishable(int pid,String pname,int qty,LocalDate mfg,LocalDate expdate) {
		super(pid,pname,qty,mfg);
		this.expdate = expdate;
	}

	public LocalDate getExpdate() {
		return expdate;
	}

	public void setExpdate(LocalDate expdate) {
		this.expdate = expdate;
	}

	@Override
	public String toString() {
		return "Perishable [expdate=" + expdate + "]";
	}
	

}
