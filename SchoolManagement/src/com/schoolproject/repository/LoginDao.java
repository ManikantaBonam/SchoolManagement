package com.schoolproject.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	
		 private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
		    private static final String USERNAME = "scott";
		    private static final String PASSWORD = "tiger";

		    public static String isStudent(String username, String password) throws ClassNotFoundException {
		   System.out.println(username+" "+password);
		    	Class.forName("oracle.jdbc.driver.OracleDriver"); 
		    	try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
		            String sql = "SELECT ROLE FROM studenttable WHERE username=? AND password=?";
		            PreparedStatement stmt = con.prepareStatement(sql);
		            stmt.setString(1, username);
		            stmt.setString(2, password);
		            ResultSet rs = stmt.executeQuery();
		            if (rs.next()) {
		            	System.out.println(rs.getString("ROLE"));
		                return rs.getString("ROLE");
		               
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return null; 
		    }

		    }
		


