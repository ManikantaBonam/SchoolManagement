package com.schoolproject.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schoolproject.Model.School;
import com.schoolproject.repository.ViewDao;




@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	 ViewDao vd = new ViewDao();
     
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			try {
			    List<School> b = vd.view();
			    PrintWriter pw = response.getWriter();
			    String htmlResponse = "<html><head><style>table { border-collapse: collapse; width: 100%; } th, td { padding: 8px; text-align: left; border-bottom: 1px solid #ddd; } th { background-color: #4CAF50; }tr:nth-child(even) { background-color: #f2f2f2; } tr:hover { background-color: #ddd; } </style></head><body><table border=1><tr><th>ID</th><th>CLASS</th><th>SECTION</th></tr>";
			    for (School school : b) {
			        htmlResponse += "<tr><td>" + school.getId() + "</td><td>" + school.getClasses() + "</td><td>" + school.getSection() + "</td></tr>";
			    }
			    htmlResponse += "</table><br><br>";
				   // htmlResponse += "<form action='LogoutServlet' method='post'><input type='submit' value='Logout'></form>";
				    htmlResponse += "<button onclick='window.location.href=\"AdminDashBoard.jsp\"'>Back</button>"; 
				    htmlResponse += "</body></html>";
				    pw.println(htmlResponse);
			} catch (Exception e) {
			    e.printStackTrace();
			}


	}
	}