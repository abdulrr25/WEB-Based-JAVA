package com.demo.test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
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
				boolean status=pservice.addNewProduct();
				if(status) {
					System.out.println("Add new product successfully");
				}else {
					System.out.println("Not Added");
				}
			}
			
			case 2->{
				System.out.println("Enter id: ");
				int id=sc.nextInt();
				boolean status=pservice.deletebyId(id);
				if(status) {
					System.out.println("Deleted successfully");
				}else {
					System.out.println("Not Found");
				}
			}
			
			case 3->{
				System.out.println("enter id");
				int id=sc.nextInt();
				System.out.println("enter qty");
				int qty=sc.nextInt();
				System.out.println("enter price");
				double price=sc.nextDouble();
				boolean status=pservice.modifyById(id,qty,price);
				if(status) {
					System.out.println("product updated successfully");
				}else {
					System.out.println("Not updated");
				}
			}
			
			case 4->{
				System.out.println("Enter the id ");
				int id = sc.nextInt();
				Product p = pservice.findById(id);
				if(p!=null) {
					
				System.out.println(p);
				}
				else {
					System.out.println("Not found");
				}
			}
			case 5->{
				List<Product> plist = pservice.showAllProduct();
				plist.forEach(System.out::println);
			}
			case 6->{
				List<Product> plist =pservice.sortByPrice();
				if(plist!=null) {
					
				plist.forEach(System.out::println);
				}
				else {
					System.out.println("No Value Found");
				}
			}
			case 7->{
				sc.close();
				pservice.CloseConnection();
				System.out.println("Thankyou For visiting");
			}
			}
			
		}while(choice!=7);

	}

}
