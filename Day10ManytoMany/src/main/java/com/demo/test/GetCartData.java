package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Cart;
import com.demo.beans.Item;

public class GetCartData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf =new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		System.out.println("Before Get Cart");
		Cart c1 = session.load(Cart.class, 3);
		Cart c2 = session.load(Cart.class, 2);
		System.out.println("After Get Cart");
		System.out.println("Before Get items");
		Item e1 = session.load(Item.class, 32);
		Item e2 = session.load(Item.class, 33);
		System.out.println("After get Items");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(e1.getCset());
		System.out.println(e2.getCset());
		tr.commit();
		session.close();
		sf.close();
	}

}
