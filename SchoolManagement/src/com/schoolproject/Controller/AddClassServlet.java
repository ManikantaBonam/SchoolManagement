package com.schoolproject.Controller;
 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schoolproject.repository.AddClass;


@WebServlet("/AddClassServlet")
public class AddClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	AddClass ad=new AddClass();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id=request.getParameter("classid");
		String classes=request.getParameter("class");
		String section=request.getParameter("section");
		
		
		String result=null;
		try {
			 result=ad.addClass(id,classes,section);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//response.getWriter().write(result);
		PrintWriter out=response.getWriter();
		if(result.equalsIgnoreCase("Inserted Successfully")){
			out.println("Inserted Successfully");
			RequestDispatcher rd=request.getRequestDispatcher("AdminDashBoard.html");
			rd.forward(request,response);
		}else{
			out.println("Failed To Insert");
			RequestDispatcher rd=request.getRequestDispatcher("AddClass.html");
		    rd.forward(request,response);
		}
		
		
		
	}

}
