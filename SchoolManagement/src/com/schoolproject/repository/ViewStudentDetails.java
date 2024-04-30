package com.schoolproject.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.schoolproject.Model.Student;


public class ViewStudentDetails {
	public List<Student> view() throws ClassNotFoundException, SQLException  {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Student> all = new ArrayList<Student>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			pstmt = conn.prepareStatement("SELECT * FROM studenttable WHERE role = ?");
	        pstmt.setString(1, "student");
	        rs = pstmt.executeQuery();
			
				while (rs.next()) {
					
					Student b=new Student();
					b.setId(rs.getInt(1));
					b.setUsername(rs.getString(2));
					b.setPassword(rs.getString(3));
					b.setRole(rs.getString(4));
					b.setName(rs.getString(5));
					b.setSurname(rs.getString(6));
					b.setFatherName(rs.getString(7));
					b.setGender(rs.getString(8));
					b.setClasses(rs.getString(9));
					b.setSection(rs.getString(10));
					Timestamp timestamp=rs.getTimestamp(11);
					b.setLoginDate(timestamp);

                        all.add(b);
			} 

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				conn.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(rs!=null) {
				rs.close();
			}
		}
		return all;

	}

}





