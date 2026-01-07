package in.co.rays.dynamic.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteMarksheet {
	
	public static void main(String[] args) throws Exception {
		//delete1();
		//delete2();
	//	delete3(6);
		
	}
	public static void delete1() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("Delete from marksheet where id = 2");
		int i = pstmt.executeUpdate();

		System.out.println("dataintert " + i);
		
	}
public static void delete2() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("Delete from marksheet where id = ?");
		pstmt.setInt(1, 5);
		int i = pstmt.executeUpdate();

		System.out.println("dataintert " + i);
		
	}
public static void delete3(int id) throws Exception{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
	PreparedStatement pstmt = conn.prepareStatement("Delete from marksheet where id = ?");
	pstmt.setInt(1, id);
	int i = pstmt.executeUpdate();
	

	System.out.println("dataintert " + i);
	
}


}
