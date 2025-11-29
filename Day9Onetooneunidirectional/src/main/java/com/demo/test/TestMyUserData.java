package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Address;
import com.demo.beans.MyUser;

public class TestMyUserData {
	public static void main(String args[]) {
		SessionFactory sh=new Configuration().configure().buildSessionFactory();
		Session session=sh.openSession();
		Transaction tr = session.beginTransaction();
		
//		Address a1=new Address(1,"SBRoad","Pune","411016");
//		MyUser u1=new MyUser(1,"Aakanksha","97456",a1);
//
//		Address a3=new Address(2,"XYZ","Kolhapur","411014");
//		MyUser u3=new MyUser(2,"Neha","974566",a3);
		
		Address a1=new Address("s. B. Road","Pune","411016");
		MyUser u1=new MyUser(12,"Ashu","1111",a1);
		Address a2=new Address("Bane","Pune","411045");
		MyUser u2=new MyUser(13,"Rajan","2222",a2);
		
		session.save(a1);
		session.save(u1);
		session.save(a2);
		session.save(u2);
		
		tr.commit();
		session.close();
		sh.close();

	}
}
