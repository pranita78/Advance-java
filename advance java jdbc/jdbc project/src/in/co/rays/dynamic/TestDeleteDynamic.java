package in.co.rays.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

	
	public class TestDeleteDynamic {


		   // test Delete 1;
			// testDelete2();
		   // testDelete3(11);


		public static void testDelete1() throws Exception {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("delete from emp where id = 10");

			int i = pstmt.executeUpdate();

			System.out.println("data deleted => " + i);
			
		}
		
	}



