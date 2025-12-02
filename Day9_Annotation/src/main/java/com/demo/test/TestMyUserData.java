package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.MyUser;
import com.demo.beans.Product;


public class TestMyUserData {
	public static void main(String args[]) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		MyUser u1=new MyUser(300,"disha","disha@gmail.com");
		MyUser u2=new MyUser(310,"Abdul","aassdfs@gmail.com");
		Product p1=new Product(1,"lays22",23,45);
		Product p2=new Product(2,"nachos333",23,123);
		session.save(u1);
		session.save(u2);
		session.save(p1);
		session.save(p2);
		tr.commit();
		
		session.close();
		sf.close();
		
	}
}
