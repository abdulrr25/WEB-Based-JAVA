package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Address;
import com.demo.beans.Faculty;

public class TestFacData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		Faculty f = (Faculty) ctx.getBean("f1");
		System.out.println(f);
	}

}
