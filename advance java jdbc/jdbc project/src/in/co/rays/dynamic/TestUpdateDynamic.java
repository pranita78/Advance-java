package in.co.rays.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestUpdateDynamic {

	private static Object testUpdate2;

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("update emp set namee = 'anaya' where id = 15");

		int i = pstmt.executeUpdate();

		System.out.println("data updated: " + i);

		
		
	}
	public static void testUpdate2() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"update emp set id = ?, name = ?, salary ?, where id = ?");

	}
		}
	
		
	
		
	
	


