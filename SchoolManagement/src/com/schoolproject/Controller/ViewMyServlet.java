package com.schoolproject.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.schoolproject.Model.Student;
import com.schoolproject.repository.ViewMyDetails;


@WebServlet("/ViewMyServlet")
public class ViewMyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ViewMyDetails vm=new ViewMyDetails();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String loggedInUsername = (String) session.getAttribute("username");

        if (loggedInUsername != null) {
            
        	try {
        	    List<Student> b = vm.getUserDetails(loggedInUsername);
        	    PrintWriter pw = response.getWriter();
        	    String htmlResponse = "<html><head><style>body { font-family: Arial, sans-serif; } table { border-collapse: collapse; width: 100%; } th, td { padding: 10px; border-bottom: 1px solid #ddd; text-align: left; } th { background-color: #4CAF50; color: white; } tr:nth-child(even) { background-color: #f2f2f2; } tr:hover { background-color: #ddd; }</style></head><body><table border=1><tr><th>ID</th><th>USERNAME</th><th>PASSWORD</th><th>ROLE</th><th>NAME</th><th>SURNAME</th><th>FATHER NAME</th><th>GENDER</th><th>CLASS</th><th>SECTION</th><th>REGISTRATION DATE</th></tr>";
        	    for (Student student : b) {
        	        htmlResponse += "<tr><td>" + student.getId() + "</td><td>" + student.getUsername() + "</td><td>" + student.getPassword() + "</td><td>" + student.getRole() + "</td><td>" + student.getName() + "</td><td>" + student.getSurname() + "</td><td>" + student.getFatherName() + "</td><td>" + student.getGender() + "</td><td>" + student.getClasses() + "</td><td>" + student.getSection() + "</td><td>" + student.getLoginDate() + "</td></tr>";
        	    }
        	    htmlResponse += "</table><br><br>";
        	    //htmlResponse += "<form action='LogoutServlet' method='post'><input type='submit' value='Logout'></form>";
        	    htmlResponse += "<button onclick='window.location.href=\"StudentDashBoard.jsp\"'>Back</button>"; 
        	    htmlResponse += "</body></html>";
        	    pw.println(htmlResponse);
        	} catch (Exception e) {
        	    e.printStackTrace();
        	}


    	}
    	}
}