package com.demo.bean;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Productss")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private int qty;
	private double price;
	private String Iname;
	
	@ManyToMany
	@JoinTable(
 	        name = "cart_product",
 	        joinColumns=@JoinColumn(name="pid"),
 	       inverseJoinColumns=@JoinColumn(name="cid")
 	    )
	Set<Cart> cset;

	public Product() {
		super();
	}

	public Product(int pid, int qty, double price, String iname, Set<Cart> cset) {
		super();
		this.pid = pid;
		this.qty = qty;
		this.price = price;
		Iname = iname;
		this.cset = cset;
	}

	public Product(int pid, int qty, double price, String iname) {
		super();
		this.pid = pid;
		this.qty = qty;
		this.price = price;
		Iname = iname;
	}

	public int getpid() {
		return pid;
	}

	public void setpid(int pid) {
		this.pid = pid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIname() {
		return Iname;
	}

	public void setIname(String iname) {
		Iname = iname;
	}

	public Set<Cart> getCset() {
		return cset;
	}

	public void setCset(Set<Cart> cset) {
		this.cset = cset;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", qty=" + qty + ", price=" + price + ", Iname=" + Iname + "]";
	}
	
	
}
