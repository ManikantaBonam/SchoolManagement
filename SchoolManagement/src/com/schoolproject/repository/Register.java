package com.schoolproject.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Register {
	
	public String registerDetails(int id,String username,String password,String role,String name,String surname,String fatherName,String gender,String classes,String section,String dateString) throws SQLException{
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try{
			String driver="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String pass="tiger";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(driver,user,pass);
			
			String sql = "INSERT INTO Studenttable (ID,USERNAME,PASSWORD,ROLE,NAME,SURNAME,FATHER_NAME, GENDER,CLASS,SECTION, REGISTRATION_DATE) VALUES (?,?,?,?,?,?,?,?,?,?,(TO_TIMESTAMP(?,'YYYY-MM-DD HH24:MI:SS')))";

			pst=con.prepareStatement(sql);
			pst.setInt(1,id );
			pst.setString(2,username );
			pst.setString(3, password);
			pst.setString(4, role);
			pst.setString(5, name);
			pst.setString(6, surname);
			pst.setString(7, fatherName);
			pst.setString(8, gender);
			pst.setString(9, classes);
			pst.setString(10, section);
			//pst.setTimestamp(10, Timestamp.valueOf(registrationDate));
			pst.setString(11,dateString );
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

		
	