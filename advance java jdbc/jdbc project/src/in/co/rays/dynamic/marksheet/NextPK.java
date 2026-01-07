package in.co.rays.dynamic.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NextPK {
	
	public static int getNextPk() throws ClassNotFoundException, SQLException {
		int pk =0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from Marksheet");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
	  }
		return pk+1;
	}	
}

