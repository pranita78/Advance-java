package in.co.rays.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
	
	public static void main(String[] args) throws Exception  {
		
		//testInsert1();
		//testInsert2();
		//testinsert3(15, "merra", 5000 , 10);
		//testinsert4//

		EmpolyeeBean bean = new EmpolyeeBean ();
		
		bean.setId(22);
		bean.setName("khush");
		bean.setSalary(50000);
		bean.setDept_id(8);



		

		testInser4(bean);

		
	
		
	}
	//testinsert 1
	private static void testInsert11() throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
		
	PreparedStatement pstmt = conn.prepareStatement("insert into emp values(25, 'pranita', 30000, 1)");
	int i = pstmt.executeUpdate();
	
		System.out.println("Data insert" + i);
		 

}


	//test insert 2//	
	public static void testInsert2() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
		
	PreparedStatement pstmt = conn.prepareStatement("insert into emp values(?, ?, ?, ?)");
	        pstmt.setInt(1, 5);
	        pstmt.setString(2, "ritik");
	        pstmt.setInt(3, 20000);
	        pstmt.setInt(2, 3);
		
		
		
	}

	 //testinsert3//
	
	public static void testinsert3(int Id, String Name, int Salary, int Dept_id) throws Exception {
		// TODO Auto-generated method stub

	
	
	Class.forName("com.mysql.cj.jdbc.Driver");

	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");

	PreparedStatement pstmt = conn.prepareStatement("insert into emp values(?, ?, ?, ?)");

			pstmt.setInt(1, Id);
			pstmt.setString(2, Name);
			pstmt.setInt(3, Salary);
		    pstmt.setInt(4, Dept_id);
		    
		    int i = pstmt.executeUpdate();
		    
		    System.out.println("Data inserted => " + i);
		
	}
	//testinsert4//
	
	public static void testInser4(EmpolyeeBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into emp values(?, ?, ?, ?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getSalary());
		pstmt.setInt(4, bean.getDept_id());

		int i = pstmt.executeUpdate();

		System.out.println("data inserted => " + i);

	}

	
}

