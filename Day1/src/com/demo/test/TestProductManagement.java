package com.demo.test;

import java.util.Scanner;
import com.demo.service.*;

public class TestProductManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int choice=0;
		ProductService pservice=new ProductServiceImpl();
		do {
			System.out.println("1.Add new product\n 2.Delete product\n 3.Modify product");
			System.out.println("4.find by id\n 5.Display all\n 6.Display in sorted order\n 7.exit");
			System.out.println("Enter your choice: ");
			choice=sc.nextInt();
			switch(choice) {
			case 1->{
				boolean status=pservice.addnewproduct();
				if(status) {
					System.out.println("Add new product successfully");
				}else {
					System.out.println("Not Added");
				}
			}
			case 7->{
				sc.close();
				System.out.println("Thankyou For visiting");
			}
			}
			
		}while(choice!=7);

	}

}
