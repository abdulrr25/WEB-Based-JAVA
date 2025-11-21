package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.MyUser;
import com.demo.services.LoginService;
import com.demo.services.LoginServicesImpl;

public class LoginServlet extends HttpServlet{
   public void doPost(HttpServletRequest req , HttpServletResponse resp) throws IOException, ServletException {
	   resp.setContentType("text/html");
	   PrintWriter out = resp.getWriter();
	   String uname = req.getParameter("uname");
	   String pass = req.getParameter("pass");
	   LoginService lservice = new LoginServicesImpl();
	   MyUser user = lservice.validateUser(uname,pass);
	   if(user!=null) {
		   out.print("<h1> Valid User</h1>");
	   }
	   else {
		   out.print("<h1>Invalid User</h1>");
		   RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		   rd.include(req, resp);
	   }
   }
    
}
