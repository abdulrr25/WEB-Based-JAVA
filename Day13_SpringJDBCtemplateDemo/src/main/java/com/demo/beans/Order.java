package com.demo.beans;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanNameAware;

public class Order implements BeanNameAware {
	private int orderid;
	private String cname;
	private List<Product> plist;
	private double orderamount;

	public Order() {
		super();
	}

	public Order(int orderid, String cname, List<Product> plist, double orderamount) {
		super();
		this.orderid = orderid;
		this.cname = cname;
		this.plist = plist;
		this.orderamount = orderamount;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<Product> getPlist() {
		return plist;
	}

	public void setPlist(List<Product> plist) {
		this.plist = plist;
	}

	public double getOrderamount() {
		return orderamount;
	}

	public void setOrderamount(double orderamount) {
		this.orderamount = orderamount;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", cname=" + cname + ", plist=" + plist + ", orderamount=" + orderamount
				+ "]";
	}

	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("In SetBeanName of BeanNameAware");
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("In setBeanFactory of BeanFactoryAware");
	}
	public void afterPropertiesSet() throws Exception {
		//you can make changes in the bean if needed
		plist.forEach(System.out::println);
		
		//convert productlist to List of Double to save amount for each product
		List<Double> amtlist=plist.stream().map(product->product.getQty()*product.getPrice())
				.collect(Collectors.toList());
		//calculate total amount
		this.orderamount=amtlist.stream().reduce(0.0,(acc,amt)->acc+amt);
		System.out.println("in afterPropertiesSet of InitializingBean");
		
	}
	public void myinit() {
		System.out.println("in custom init myinit");
	}
	
	public void mydestroy() {
		System.out.println("in custom destroy mydestroy");
	}
	
	
}
