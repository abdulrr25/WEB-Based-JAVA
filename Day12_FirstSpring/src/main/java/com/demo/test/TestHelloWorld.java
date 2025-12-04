package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.bean.Address;
import com.demo.bean.Employee;
import com.demo.bean.HelloWorld;
import com.demo.bean.MyUser;


public class TestHelloWorld {

	public static void main(String[] args) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("springconfig.xml");
	     HelloWorld hwbean=(HelloWorld) ctx.getBean("hw");
//	     System.out.println(hwbean);
	     
	    Employee emp=(Employee) ctx.getBean("emp1");
//	    System.out.println(emp);
	    
	    Address add=(Address) ctx.getBean("addr");
//	    System.out.println(add);

	    MyUser myusr=(MyUser) ctx.getBean("usr");
	    System.out.println(myusr);
	}

}
