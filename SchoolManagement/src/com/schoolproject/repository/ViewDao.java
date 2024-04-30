package com.schoolproject.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.schoolproject.Model.School;



public class ViewDao {
	
	public List<School> view() throws ClassNotFoundException, SQLException  {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<School> school = new ArrayList<School>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			pstmt = conn.prepareStatement("SELECT * from classtable");
			rs = pstmt.executeQuery();
			

			while (rs.next()) {
				School b=new School();
				b.setId(rs.getString(1));
				b.setClasses(rs.getString(2));
				b.setSection(rs.getString(3));
				school.add(b);

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
		return school;

	}

}



