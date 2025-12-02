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
		
		Address a1=new Address(1,"SBRoad","Pune","411016");
		MyUser u1=new MyUser(1,"Aakanksha","97456",a1);
		
		
		Address a2=new Address(1,"ABC","Satara","411013");
		MyUser u2=new MyUser(1,"Disha","97453",a1);
		Address a3=new Address(2,"XYZ","Kolhapur","411014");
		MyUser u3=new MyUser(2,"Neha","974566",a3);
		
		
		session.save(u1);
		session.save(u3);
		
		Session sessions2=sh.openSession();
		Transaction tr1=sessions2.beginTransaction();
		System.out.println("Before get");
		MyUser u4 = sessions2.get(MyUser.class,1);
		System.out.println("After get");
		System.out.println(u4);
		
//		Session session3=sh.openSession();
//		Transaction tr2=session3.beginTransaction();
//		System.out.println("Before get");
//		MyUser u5=session3.load(MyUser.class, 1);
//		System.out.println("After get");
//		System.out.println(u5);
//		
		tr.commit();
		session.close();
		sh.close();

	}
}
