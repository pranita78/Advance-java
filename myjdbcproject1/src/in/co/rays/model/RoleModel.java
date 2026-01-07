package in.co.rays.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.RoleBean;

public class RoleModel extends BaseBean{
	
	public static Integer nextPk() throws Exception{
		int pk = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_role");
		
		ResultSet rs =  pstmt.executeQuery();
		while(rs.next()) {
			pk = rs.getInt(1)+1;
		}
		
		
		return pk;
		
		
		
	}
	
	public static void add(RoleBean bean) throws Exception {
	    int pk = nextPk();
	    Class.forName("com.mysql.cj.jdbc.Driver");

	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

	    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO st_role (id, name, description) VALUES (?, ?, ? )" );

	    pstmt.setInt(1, pk);
	    pstmt.setString(2, bean.getName());
	    pstmt.setString(3, bean.getDescription());
	    

	    int i = pstmt.executeUpdate();
	    System.out.println("Data inserted = " + i);

	   
	}
	
   public static void update(RoleBean bean) throws Exception {
	  
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");

	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

	    PreparedStatement pstmt = conn.prepareStatement("update st_role set name = ?, description = ? where id = ?");
	    
	    
	    pstmt.setString(1, bean.getName() );
	    pstmt.setString(2, bean.getDescription());
	    pstmt.setInt(3, (int) bean.getId());
	   
	    
	    int i = pstmt.executeUpdate();
	    System.out.println("Data Updated = " + i);
	   
	   
   }
   public static void delete(int id) throws Exception {
	  
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");

	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

	    PreparedStatement pstmt = conn.prepareStatement("delete from st_role where id = ?");
	    
	    
	   
	    pstmt.setInt(1,id);
	   
	    
	    int i = pstmt.executeUpdate();
	    System.out.println("Data Deleted = " + i);
	   
	   
   }
   public RoleBean findByPk(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from st_role where id = ?");

		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		RoleBean bean = null;

		while (rs.next()) {
			bean = new RoleBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setDescription(rs.getString(3));
			
		}
		return bean;
	}
  
	
	
	public List search(RoleBean bean, int pageNo, int pageSize) throws Exception {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
		StringBuffer sql = new StringBuffer("select * from st_role where 1=1");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id =" + bean.getId());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + " ," + pageSize);
		}
		System.out.println("sql=>" + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		List list = new ArrayList();
		while (rs.next()) {
			bean = new RoleBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDescription(rs.getString(3));
			bean.setCreatedBy(rs.getString(4));
			bean.setModifiedBy(rs.getString(5));
			bean.setCreatedDatetime(rs.getTimestamp(6));
			bean.setModifiedDatetime(rs.getTimestamp(7));
			list.add(bean);
		}

		return list;

	}
}