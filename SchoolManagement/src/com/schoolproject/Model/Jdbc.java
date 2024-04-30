package com.schoolproject.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");

		
		Statement st=con.createStatement();
		
		String sql="create table Admintable(id number(5) PRIMARY KEY,username varchar2(20),password varchar2(20),Role varchar2(10))";
		//String sql = "CREATE TABLE classtable (id NUMBER(5) PRIMARY KEY,Class VARCHAR2(20),Section VARCHAR2(20))";
		int i =st.executeUpdate(sql);
		
		System.out.println("Admin Table Created");
		
		
	}

}



