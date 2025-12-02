package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Faculty;

public class TestCourseData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sh=new Configuration().configure().buildSessionFactory();
		Session session=sh.openSession();
		Transaction tr= session.beginTransaction();
		Course c1= new Course(1,"AI","6Month");
		Faculty f1=new Faculty(1,"XYZ","AI/ML");
		session.save(c1);
		session.save(f1);
		
		
		tr.commit();
		session.close();
		sh.close();
		

	}

}
