package com.schoolproject.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddClass {
	
public String addClass(String id,String Classes,String Section) throws SQLException{

	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;

	try{
	String driver="jdbc:oracle:thin:@localhost:1521:orcl";
	String user="scott";
	String pass="tiger";
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection(driver,user,pass);
	
	String sql = "INSERT INTO classtable (ID, CLASS,SECTION) VALUES (?, ?, ?)";

	pst=con.prepareStatement(sql);
	pst.setString(1,id );
	pst.setString(2, Classes);
	pst.setString(3, Section);
	rs=pst.executeQuery();
	
}catch(Exception e){
	e.printStackTrace();
}
if(rs.next()){
	return "Inserted Successfully";
}
else{
	return "Not Inserted";
}



}


}

