package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.bean.MyUser;
import com.demo.bean.Product;

@WebServlet("/addtocart")
public class AddToCart extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        MyUser user = (MyUser) session.getAttribute("user"); // fixed attribute name

        if(user != null && user.getRole().equals("user")) {
            int pid = Integer.parseInt(request.getParameter("pid"));
            String pname = request.getParameter("pname");
            double price = Double.parseDouble(request.getParameter("price"));
            int ordqty = Integer.parseInt(request.getParameter("qty"));

            Set<Product> cart = (Set<Product>) session.getAttribute("cart");
            if(cart == null) {
                cart = new HashSet<>();
            }

            Product p = new Product(pid, pname, ordqty, price, null, 0);
            cart.add(p);

            session.setAttribute("cart", cart); // save back to session
			 cart.stream().forEach(System.out::println);

            RequestDispatcher rd = request.getRequestDispatcher("ShowProduct.jsp"); // forward to cart page
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.include(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

