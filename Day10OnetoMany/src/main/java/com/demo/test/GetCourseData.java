package com.demo.test;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Student;

public class GetCourseData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf =new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		System.out.println("Before Get Cart");
		Course c1 = session.load(Course.class, 13);
		Course c2 = session.load(Course.class, 12);
		System.out.println("After Get Cart");
		System.out.println("Before Get items");
		Student s1 = session.load(Student.class, 2);
		Student s2 = session.load(Student.class, 3);
		System.out.println("After get Items");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(s1.getCour());
		System.out.println(s2.getCour());
		tr.commit();
		session.close();
		sf.close();
	}

}
