package com.demo.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.MyUser;
import com.demo.bean.Product;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String uid = request.getParameter("uid");
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        
        MyUser user = new MyUser(uid, uname, pass, email, "user");
        LoginService lservice = new LoginServiceImpl();
        boolean status = lservice.register(user);
        
        if(status) {
            // Registration successful → forward to product page
            RequestDispatcher rd = request.getRequestDispatcher("Login.html");
            rd.forward(request, response);
        } else {
            // Registration failed → show registration page again
            request.setAttribute("errorMessage", "Registration failed. Please try again.");
            RequestDispatcher rd = request.getRequestDispatcher("register.html");
            rd.include(request, response);
        }
    }
}

