package com.schoolproject.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");

		
		Statement st=con.createStatement();
		
		String sql="insert into Admintable values(1,'Admin','Admin','Admin')";
		
		int i =st.executeUpdate(sql);
		
		System.out.println("Admin data inserted");

	}

}
