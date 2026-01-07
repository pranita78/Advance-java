package in.co.rays.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

public class TestInsert {
	
		public static void main(String[] args) throws ClassNotFoundException, Exception {
			
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
			
		Statement stmt = conn.createStatement();
			int i  = stmt.executeUpdate("insert into emp values(20, 'pranita', 30000, 2)");
			
			System.out.println("Data insert" + i);
			 
		
	
		
	}

}
