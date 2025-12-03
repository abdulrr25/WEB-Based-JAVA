package com.demo.test;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.bean.NonPerishable;
import com.demo.bean.Perishable;
import com.demo.bean.Product;

public class TestInheritanceSingle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sh=new Configuration().configure().buildSessionFactory();
		Session session=sh.openSession();
		Transaction tr=session.beginTransaction();
		
		Product p=new Perishable(1,"XYZ", 3,LocalDate.of(2025,11,11),LocalDate.of(2025,12,11));
		Product p1=new NonPerishable(2,"ABC",5,LocalDate.of(2025, 8, 12),5);
		session.save(p);
		session.save(p1);
		
		tr.commit();
		session.close();
		sh.close();

	}

}
