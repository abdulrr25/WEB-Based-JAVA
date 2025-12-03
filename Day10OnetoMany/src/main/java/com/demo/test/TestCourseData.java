package com.demo.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Student;

public class TestCourseData {

	public static void main(String[] args) {
		
		SessionFactory sh=new Configuration().configure().buildSessionFactory();
		Session session =sh.getCurrentSession();
		Transaction tr=session.beginTransaction();
		
		Course c=new Course(12,"AI/ML","4 months");
		Course c1=new Course(13,"CDAC","6 months");
		Student s1= new Student(1,"XYZ",90,c);
		Student s2= new Student(2,"PQR",89,c);
		Student s3=new Student(3,"ABC",78,c1);
		Student s4=new Student(4,"EFG",79,c1);
		Set<Student> set1=new HashSet<Student>();
		set1.add(s1);
		set1.add(s2);
		Set<Student> set2=new HashSet<Student>();
		set2.add(s3);
		set2.add(s4);
		c.setEset(set1);
		c1.setEset(set2);
		session.save(c);
		session.save(c1);
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		
		
		
		tr.commit();
		session.close();

		sh.close();
		
		
		
		
					


		

		
		


	}

}
