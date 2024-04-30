package com.schoolproject.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ClassServlat")
public class ClassServlat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String JDBC_USER = "scott";
    private static final String JDBC_PASSWORD = "tiger";
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Set<String> s = getValues();
		 System.out.println(s);
	        
	      System.out.println(s);
	     request.setAttribute("Object", s);
	     request.getRequestDispatcher("AddSection.jsp").forward(request, response);
	     
	    }
	    private Set<String> getValues() {
	      
	        Set<String> mp=new HashSet<>();
	        try {
	        	Class.forName("oracle.jdbc.driver.OracleDriver");
	            try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	                    PreparedStatement statement = conn.prepareStatement("SELECT CLASS FROM classtable");
	                    ResultSet resultSet = statement.executeQuery()) {

	                while (resultSet.next()) {
	                
	                    String classes = resultSet.getString(1);
	                    mp.add(classes);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            
	        }
	        return mp;
	    }
	
	}
