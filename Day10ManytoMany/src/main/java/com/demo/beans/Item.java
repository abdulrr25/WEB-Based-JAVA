package com.demo.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="Itemmm")
public class Item {
	
	@Id
	private int Item_id;
	private int qty;
	private double price;
	private String Iname;
	
	@ManyToMany(mappedBy="sItem",cascade=CascadeType.ALL)
	Set<Cart> cset;

	public Item() {
		super();
	}
	

	

	public Item(int item_id, int qty, double price, String iname, Set<Cart> cset) {
		super();
		Item_id = item_id;
		this.qty = qty;
		this.price = price;
		Iname = iname;
		this.cset = cset;
	}

	public int getItem_id() {
		return Item_id;
	}

	public void setItem_id(int item_id) {
		Item_id = item_id;
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
		return "Item [Item_id=" + Item_id + ", qty=" + qty + ", price=" + price + ", Iname=" + Iname + "]";
	}
	

}
