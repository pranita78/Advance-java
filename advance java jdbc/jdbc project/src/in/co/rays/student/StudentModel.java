package in.co.rays.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentModel {
	
	public Integer nextPk() throws Exception {
		
	int pk = 0;
	
	Class.forName("com.mysql.cj.jdbc.Driver");

	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

	PreparedStatement pstmt = conn.prepareStatement("select max(id) from student");
	
	ResultSet rs = pstmt.executeQuery();

	while (rs.next()) {
		pk = rs.getInt(1);
	}
	return pk + 1;

	}
	
	
	public void add(StudentBean bean) throws Exception {
		
//		StudentBean existBean = findByLoginId(bean.getLoginId());
//	   
//		if (existBean != null) {
//			throw new Exception("Login Id already exist..!!");
//			
//		}
		int pk = nextPk();
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into student values(?, ?, ?, ?, ?, ?, ?,?,)");
		
	     pstmt.setInt(1, pk);
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setDate(4, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(5,bean.getGender());
	    pstmt.setLong(6, bean.getMobilno());
	    pstmt.setString(7, bean.getEmail());
	    pstmt.setString(8, bean.getCollegeName());
	    
	    int i =  pstmt.executeUpdate();
	    
	    System.out.println("data inserted: " + i);
	    
	    
	}
}
