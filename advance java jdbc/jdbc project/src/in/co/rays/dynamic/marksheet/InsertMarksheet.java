package in.co.rays.dynamic.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMarksheet {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// insertMarksheet();
		//insertMarksheet2();
		//insertMarksheet3(24, 85, "Merra", 75, 48, 75);
		MarksheetBean bean = new MarksheetBean();
		bean.setId(25);
		bean.setRollNo(51);
		bean.setName("Kavya");
		bean.setPhy(55);
		bean.setChem(85);
		bean.setMaths(58);
		insertMarksheet4(bean);
		
	}

	public static void insertMarksheet() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(21,15,'shyam',85,95,70)");
		int i = pstmt.executeUpdate();

		System.out.println("dataintert " + i);
	}

	public static void insertMarksheet2() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet value(?,?,?,?,?,?)");
		pstmt.setInt(1, 23);
		pstmt.setInt(2, 16);
		pstmt.setString(3, "siya");
		pstmt.setInt(4, 45);
		pstmt.setInt(5, 100);
		pstmt.setInt(6, 98);

		int i = pstmt.executeUpdate();

		System.out.println("datainsert" + i);
	}
	
	public static void insertMarksheet3(int id, int rollno, String name, int phy,int chem,int maths) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet value(?,?,?,?,?,?)");
		pstmt.setInt(1, id);
		pstmt.setInt(2, rollno);
		pstmt.setString(3, name);
		pstmt.setInt(4, phy);
		pstmt.setInt(5, chem);
		pstmt.setInt(6, maths);

		int i = pstmt.executeUpdate();

		System.out.println("datainsert" + i);
	}
	
	public static void insertMarksheet4( MarksheetBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet value(?,?,?,?,?,?)");
		pstmt.setInt(1, NextPK.getNextPk());
		pstmt.setInt(2, bean.getRollNo());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4, bean.getPhy());
		pstmt.setInt(5, bean.getChem());
		pstmt.setInt(6, bean.getMaths());

		int i = pstmt.executeUpdate();

		System.out.println("datainsert" + i);
	}
	


}
