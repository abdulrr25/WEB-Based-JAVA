package com.demo.test;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;

public class TestConfiguration {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		MessageSource ms=ctx.getBean(ResourceBundleMessageSource.class);
		System.out.println("1. Marathi \n2. US English\n 3. UK english\n4. others \n choice:");
        int choice=sc.nextInt();
        Locale local = null;
        switch(choice) {
        case 1->{
        	local=new Locale("my","marathi");
        	System.out.println("Country Name : "+local.getCountry()+"Language : "+local.getLanguage());
        	break;
        }
        case 2->{
        	local=Locale.US;
        	System.out.println("Country Name : "+local.getCountry()+"Language : "+local.getLanguage());
        	break;
        }
        case 3->{
        	local=Locale.UK;
        	System.out.println("Country Name : "+local.getCountry()+"Language : "+local.getLanguage());
        	break;
        }
        }
        
		String ms1 = ms.getMessage("msg.pay", null, local);
		String welcmmsg = ms.getMessage("msg.welcome", new Object[] { "Aakanksha" }, local);
		String paymsg = ms.getMessage("msg.billmsg", null, local);
		String cur = ms.getMessage("msg.currency", null, local);
		
		
		 System.out.println(ms1);
	        System.out.println(welcmmsg);
	        System.out.println(paymsg);
	        double amount=sc.nextDouble();
	        System.out.println("Your bill amount : "+ amount+" "+cur+"is receieved");
	        
	}

}
