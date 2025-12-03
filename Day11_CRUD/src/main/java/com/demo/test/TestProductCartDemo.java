package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.bean.Cart;
import com.demo.bean.Product;
import com.demo.service.CartService;
import com.demo.service.CartServiceImpl;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;


public class TestProductCartDemo {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    ProductService pservice = new ProductServiceImpl();
	    CartService cservice = new CartServiceImpl();

	    int choice = 0;
	    do {
	        System.out.println("1. Add Product");
	        System.out.println("2. Add Product To Cart");
	        System.out.println("3. Show all carts");
	        System.out.println("4. Show all products");
	        System.out.println("5. Delete cart");
	        System.out.println("6. Update Product price");
	        System.out.println("7. Add Product in existing cart");
	        System.out.println("8. Exit\nChoice:");
	        choice = sc.nextInt();

	        switch (choice) {
	            case 1 -> pservice.addNewProduct();

	            case 2 -> {
	                boolean status = cservice.addProduct();
	                System.out.println(status ? "Product added to new cart" : "Could not add product");
	            }

	            case 3 -> {
	                List<Cart> clist = cservice.getAllCart();
	                clist.forEach(System.out::println);
	            }

	            case 4 -> {
	                List<Product> plist = pservice.getAllProducts();
	                plist.forEach(System.out::println);
	            }

	            case 5 -> {
	                System.out.println("Enter the cart Id for deletion:");
	                int cid = sc.nextInt();
	                boolean status = cservice.deleteById(cid);
	                System.out.println(status ? "Cart deleted successfully" : "Cart not deleted");
	            }

	            case 6 -> {
	                System.out.println("Enter the product Id:");
	                int pid = sc.nextInt();
	                System.out.println("Enter updated price of the product:");
	                double price = sc.nextDouble();
	                boolean status = pservice.ModifyById(pid, price);
	                System.out.println(status ? "Price updated successfully" : "Price update failed");
	            }

	            case 7 -> {
	                System.out.println("Enter Cart Id to add the product:");
	                int cid = sc.nextInt();
	                System.out.println("Enter Product Id to add to the cart:");
	                int pid = sc.nextInt();
	                boolean status = cservice.addProductToCart(cid, pid);
	                System.out.println(status ? "Product added to cart successfully" : "Failed to add product to cart");
	            }

	            case 8 -> {
	                sc.close();
	                cservice.CloseMySession();
	                System.out.println("Thank you for visiting .......");
	            }
	        }
	    } while (choice != 8);
	}


}
