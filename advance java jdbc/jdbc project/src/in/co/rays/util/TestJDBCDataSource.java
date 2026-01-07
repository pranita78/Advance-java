package in.co.rays.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestJDBCDataSource {
	
	public static void main(String[] args)throws Exception {
		
		for (int i = 1; i <= 50; i++) {
			
			System.out.println("Connection = "+ i);
			
			
			
			
		}
	}
	
	public static void testGet() throws Exception {
		
		Connection conn = JDBCDataSOURCE.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where id = 1");



	}

}
