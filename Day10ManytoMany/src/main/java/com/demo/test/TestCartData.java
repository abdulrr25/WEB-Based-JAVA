package com.demo.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Cart;
import com.demo.beans.Item;

public class TestCartData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sh=new Configuration().configure().buildSessionFactory();
		Session session=sh.openSession();
		Transaction tr=session.beginTransaction();
		
		Cart c1=new Cart(1,LocalDate.of(2025, 11, 2),"active");
		Cart c2=new Cart(2,LocalDate.of(2025, 12, 1),"active");
		Cart c3=new Cart(3,LocalDate.of(2025, 11, 12),"active");
		Cart c4=new Cart(4,LocalDate.of(2025, 11, 21),"active");
		Set<Cart> cset1=new HashSet<Cart>();
		cset1.add(c1);
		cset1.add(c2);
		cset1.add(c3);
		Set<Cart> cset2=new HashSet<Cart>();
		cset2.add(c4);
		cset2.add(c2);
		cset2.add(c3);
		
		Item I1=new Item(32,4,3456,"ABC",cset1);
		Item I2=new Item(33,2,3456,"XYZ",cset2);
		Item I3=new Item(34,7,3456,"PQR",cset1);
		Set<Item> Iset1=new HashSet<Item>();
		Iset1.add(I1);
		Iset1.add(I2);
		c1.setsItem(Iset1);
		
		Set<Item> Iset2=new HashSet<Item>();
		Iset2.add(I1);
		Iset2.add(I2);
		Iset2.add(I3);
		c2.setsItem(Iset2);
		c3.setsItem(Iset2);
		
		Set<Item> ISet3= new HashSet<Item>();
		ISet3.add(I2);
		c4.setsItem(ISet3);
		
		session.save(I1);
		session.save(I2);
		session.save(I3);
		tr.commit();
		session.close();
		sh.close();



		
		

		
		

	}

}
