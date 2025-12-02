package com.demo.beans;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="Cartt")
public class Cart {
	
	@Id
	private int cid;
	private LocalDate createddate;
	private String status;
	
	@ManyToMany
	Set<Item> sItem;

	public Cart() {
		super();
	}
	
	

	public Cart(int cid, LocalDate createddate, String status) {
		super();
		this.cid = cid;
		this.createddate = createddate;
		this.status = status;
	}



	public Cart(int cid, LocalDate createddate, String status, Set<Item> sItem) {
		super();
		this.cid = cid;
		this.createddate = createddate;
		this.status = status;
		this.sItem = sItem;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Item> getsItem() {
		return sItem;
	}

	public void setsItem(Set<Item> sItem) {
		this.sItem = sItem;
	}

	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", createddate=" + createddate + ", status=" + status + ", sItem=" + sItem + "]";
	}
	
	

}
