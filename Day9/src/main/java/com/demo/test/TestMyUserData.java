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
		
//		MyUser u1=new MyUser(1,"Abdul", "abdul@gmail.com");
//		MyUser u2=new MyUser("Aakanksha", "aakanksha@gmail.com");
		MyUser u3=new MyUser("Aasha", "aasha@gmail.com");
		
//		Product p1=new Product(1,"table",3,54000);
//		Product p2=new Product("chair",40,4000);
		//Session session=sf.getCurrentSession();
		
		Session session=sf.openSession();
		
		Transaction tr=session.beginTransaction();
		//saving object into session changes the state from transient to persistent
//		session.save(u2);
		session.save(u3);
//		session.save(p1);
//		session.save(p2);
		tr.commit();
		session.close();
		sf.close();
		
	}
}
