package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;


@WebServlet("/forgotpassword")
public class forgotpassword extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email = request.getParameter("email");
		String pass=request.getParameter("confpass");
		
		LoginService lservice = new LoginServiceImpl();
		boolean status= lservice.forgot(email,pass);
		if(status) {
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.forward(request, response);
		}else {
			out.print("<h1>Invalid Email</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("forgotpassword.html");
			rd.include(request, response);
			
		}
		
	}

}
