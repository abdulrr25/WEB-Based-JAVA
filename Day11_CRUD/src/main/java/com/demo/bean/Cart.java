package com.demo.bean;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="cartt")
public class Cart {
	@Id
	private int cid;
	private LocalDate createddate;
	
	@ManyToMany(mappedBy = "cset")

	
	
	Set<Product> pset;
	public Cart() {
		super();
	}

	public Cart(int cid, LocalDate createddate) {
		super();
		this.cid = cid;
		this.createddate = createddate;
	}
	public Cart(int cid, LocalDate createddate, Set<Product> pset) {
		super();
		this.cid = cid;
		this.createddate = createddate;
		this.pset = pset;
	}


	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public LocalDate getCreateddate() {
		return createddate;
	}

	public void setCreateddate(LocalDate createddate) {
		this.createddate = createddate;
	}


	public Set<Product> getPset() {
		return pset;
	}

	public void setPset(Set<Product> pset) {
		this.pset = pset;
	}

	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", createddate=" + createddate +  "]";
	}

	
	
	
}
