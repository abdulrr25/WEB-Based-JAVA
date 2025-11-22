package com.demo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.MyUser;
import com.demo.bean.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid = request.getParameter("uid");
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        
        MyUser user= new MyUser(uid,uname,pass,email,"user");
		ProductService pservice = new ProductServiceImpl();
		boolean status = pservice.register();
		
	}
	
//	@WebServlet("/register")
//	public class RegisterServlet extends HttpServlet {
//	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//	        throws ServletException, IOException {
//	        
//	        String uid = request.getParameter("uid");
//	        String uname = request.getParameter("uname");
//	        String pass = request.getParameter("pass");
//	        String email = request.getParameter("email");
//
//	        try (Connection con = DBUtil.getConnection()) {
//	            PreparedStatement ps = con.prepareStatement(
//	                "INSERT INTO user(uid, uname, pass, email) VALUES(?,?,?,?)");
//	            ps.setInt(1, Integer.parseInt(uid));
//	            ps.setString(2, uname);
//	            ps.setString(3, pass);   // ⚠️ In production: hash password!
//	            ps.setString(4, email);
//
//	            int rows = ps.executeUpdate();
//	            if (rows > 0) {
//	                response.getWriter().println("User registered successfully!");
//	            } else {
//	                response.getWriter().println("Registration failed.");
//	            }
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            response.getWriter().println("Error: " + e.getMessage());
//	        }
//	    }
//	}


}
