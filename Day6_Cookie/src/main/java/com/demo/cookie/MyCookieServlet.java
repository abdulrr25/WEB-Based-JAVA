package com.demo.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieservlet")
public class MyCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String btn = request.getParameter("btn");
		switch (btn) {
		case "add" -> {
			String val = request.getParameter("val");
			Cookie c = new Cookie(name, val);
			response.addCookie(c);
			out.println("<h1>Add cookie Successfully</h1>");

		}
		case "delete" -> {
			Cookie[] carr = request.getCookies();
			for (Cookie c : carr) {
				if (c.getName().equals(name)) {
					c.setMaxAge(0);
					response.addCookie(c);
					out.println("<h1>Delete Cookie</h1>");
					break;
				}

			}
		}
		case "display" -> {
			Cookie[] cookies = request.getCookies();
			if (cookies != null && cookies.length > 0) {
				out.println("<h3>Cookies:</h3>");
				out.println("<ul>");
				for (Cookie c : cookies) {
					out.println("<li>" + c.getName() + " =====> " + c.getValue() + "</li>");
				}
				out.println("</ul>");
			} else {
				out.println("<h3>No cookies found.</h3>");
			}
		}

		}

		RequestDispatcher rd = request.getRequestDispatcher("Cookie.html");
		rd.include(request, response);

	}

}
