package com.demo.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class AddProduct extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
		int pid = Integer.parseInt(req.getParameter("pid"));
		String name = req.getParameter("pname");
		int qty = Integer.parseInt(req.getParameter("qty"));
		Double price = Double.parseDouble(req.getParameter("price"));
		String dt = req.getParameter("expdate");
		LocalDate ldt = LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd-mm-yyyy"));
		int cid = Integer.parseInt(req.getParameter("cid"));
		
		Product P = new Product(pid,name,qty,price,ldt,cid);
		
		ProductService pservice = new ProductServiceImpl();
		boolean status = pservice.addNewProduct(P);
		
		RequestDispatcher rd = req.getRequestDispatcher("showproduct");
		rd.forward(req, res);
	}

}
