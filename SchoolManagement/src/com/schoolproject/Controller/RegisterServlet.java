package com.schoolproject.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schoolproject.repository.Register;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Register rg=new Register();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id = Integer.parseInt(request.getParameter("id"));
	        String username = request.getParameter("user");
	        String password = request.getParameter("pass");
	        String name = request.getParameter("name");
	        String surname = request.getParameter("sname");
	        String fatherName = request.getParameter("fname");
	        String gender = request.getParameter("gender");
	        String classes = request.getParameter("class");
	        String section = request.getParameter("section");
	        System.out.println("ID: " + id + ", Username: " + username + ", Password: " + password + ", Name: " + name + ", Surname: " + surname + ", Father's Name: " + fatherName + ", Gender: " + gender + ", Section: " + section + ", Registration Date: ");
	        String dateString = request.getParameter("date");
	        System.out.println("Original Date String: " + dateString);

	       
	        dateString = dateString.replace("T", " ") + ":00"; 

	        System.out.println("Adjusted Date String: " + dateString);
	        
	       
	        System.out.println("ID: " + id + ", Username: " + username + ", Password: " + password + ", Name: " + name + ", Surname: " + surname + ", Father's Name: " + fatherName + ", Gender: " + gender +", Class: " + classes + ", Section: " + section + ", Registration Date: "+ dateString);
	        
	       String role = "student";
	       
	      String result="";
	       try {
			 result=rg.registerDetails(id,username,password,role,name,surname,fatherName,gender,classes,section,dateString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       PrintWriter out=response.getWriter();
	      if(result.equalsIgnoreCase("Inserted Successfully")){
	    	  out.print("Successfully Inserted Your Data");
	    	  RequestDispatcher rd=request.getRequestDispatcher("LoginPage.html");
	    	  rd.forward(request, response);
	    			  
	      }else{
	    	  RequestDispatcher rd=request.getRequestDispatcher("StudentRegitration.html");
	    	  out.print("Values Are Mismacthed,Enter Valid Details");
	    	  rd.forward(request, response);
	    	  
	      }
	       
	}

}
