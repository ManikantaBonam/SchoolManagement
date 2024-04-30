package com.schoolproject.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false); 
	        if (session != null) {
	            session.invalidate();
	      
	           request.getRequestDispatcher("LoginPage.html"); request.getRequestDispatcher("LoginPage.html").forward(request, response);
	        }
	      
	        else {
	            response.setContentType("text/html");
	            response.getWriter().write("Already Logged Out"); 
	        }
	    }
	}
