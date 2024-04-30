package com.schoolproject.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schoolproject.repository.LoginDao;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	LoginDao ld=new LoginDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
	String user=request.getParameter("username");
	String pass=request.getParameter("password");
	System.out.println(user+" "+pass);
	
	try {
       
        String roleStudent = LoginDao.isStudent(user, pass);
        
        System.out.println(roleStudent);
        if (roleStudent != null && roleStudent.equalsIgnoreCase("Admin")) {
            request.getSession().setAttribute("username", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminDashBoard.jsp");
            dispatcher.forward(request, response);
            return; 
        } else if (roleStudent != null && roleStudent.equalsIgnoreCase("student")) {
            request.getSession().setAttribute("username", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("StudentDashBoard.jsp");
            dispatcher.forward(request, response);
            return; 
        }else {
            response.getWriter().println("Invalid username or password");
        }
        
       
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}
}