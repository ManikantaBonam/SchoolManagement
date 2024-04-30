package com.schoolproject.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schoolproject.repository.DeleteStudent;




@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	DeleteStudent ds=new DeleteStudent();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String sId=request.getParameter("no");
		
		
		String result="";
		try {
			result = ds.deleteValues(sId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//response.getWriter().write(result);
		PrintWriter out=response.getWriter();
		if(result.equalsIgnoreCase("Deleted Successfully")){
			out.println("Deleted Successfully");
			RequestDispatcher rd=request.getRequestDispatcher("ViewStudentServlet");
			rd.forward(request, response);
			
		}else{
			out.println("Failed");
			RequestDispatcher rd=request.getRequestDispatcher("ViewStudentServlet");
			rd.forward(request,response);
		}
	}

}
