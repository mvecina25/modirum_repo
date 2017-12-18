package com.modirum;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Display html type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Forward the request to page link.html
		request.getRequestDispatcher("link.html").include(request, response);

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		if (password.equals("admin")) {
			out.print("You are successfully logged in!");
			out.print("<br>Welcome, " + name);

			Cookie ck = new Cookie("name", name);
			response.addCookie(ck);
		} else {
			out.print("Sorry, Username or Password incorrect!");
			request.getRequestDispatcher("login.html").include(request, response);
		}

		out.close();
	}

}
