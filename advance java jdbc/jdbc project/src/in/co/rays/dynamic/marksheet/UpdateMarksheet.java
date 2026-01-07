package in.co.rays.dynamic.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMarksheet {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//update1();
		//update2();
		//update3(85, "Raman", 23, 52, 33, 23);
		MarksheetBean bean = new MarksheetBean();
		bean.setId(24);
		bean.setName("Anaya");
		bean.setPhy(58);
		bean.setChem(59);
		bean.setMaths(45);
		bean.setRollNo(85);
		update4(bean);

	}

	public static void update1() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("update marksheet set rollno = 5 , name = 'Priya', phy= 63, chem = 96, maths= 47 where id = 24");
		int i = pstmt.executeUpdate();

		System.out.println("dataintert " + i);
	}
	
	public static void update2() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("update marksheet set rollno = ? , name = ?, phy= ?, chem = ?, maths= ? where id = ?");
		pstmt.setInt(1, 85);
		pstmt.setNString(2, "Naman");
		pstmt.setInt(3, 55);
		pstmt.setInt(4, 88);
		pstmt.setInt(5, 77);
		pstmt.setInt(6, 25);
		int i = pstmt.executeUpdate();

		System.out.println("dataintert " + i);
	}
	
	public static void update3(int rollno, String name, int phy, int chem, int maths, int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("update marksheet set rollno = ? , name = ?, phy= ?, chem = ?, maths= ? where id = ?");
		pstmt.setInt(1, rollno);
		pstmt.setNString(2, name);
		pstmt.setInt(3, phy);
		pstmt.setInt(4, chem);
		pstmt.setInt(5, maths);
		pstmt.setInt(6, id );
		int i = pstmt.executeUpdate();

		System.out.println("dataintert " + i);
	}
	
	public static void update4( MarksheetBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("update marksheet set rollno = ? , name = ?, phy= ?, chem = ?, maths= ? where id = ?");
		pstmt.setInt(1,bean.getRollNo());
		pstmt.setNString(2, bean.getName());
		pstmt.setInt(3, bean.getPhy());
		pstmt.setInt(4, bean.getChem());
		pstmt.setInt(5, bean.getMaths());
		pstmt.setInt(6, bean.getId());
		int i = pstmt.executeUpdate();

		System.out.println("dataintert " + i);
	}
	
	

}
