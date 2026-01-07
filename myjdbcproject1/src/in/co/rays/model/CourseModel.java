package in.co.rays.model;

	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

	import in.co.rays.bean.CourseBean;

	public class CourseModel {

	    public static Integer nextPk() throws Exception {
	        int pk = 0;
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
	        PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(id) FROM st_course");
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            pk = rs.getInt(1) + 1;
	        }
	        return pk;
	    }

	    public static void add(CourseBean bean) throws Exception {
	        int pk = nextPk();
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

	        PreparedStatement pstmt = conn.prepareStatement(
	            "INSERT INTO st_course (id, name, duration, description, created_by, modified_by, created_datetime, modified_datetime) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
	        );

	        pstmt.setInt(1, pk);
	        pstmt.setString(2, bean.getName());
	        pstmt.setString(3, bean.getDuration());
	        pstmt.setString(4, bean.getDescription());
	        pstmt.setString(5, bean.getCreatedBy());
	        pstmt.setString(6, bean.getModifiedBy());
	        pstmt.setTimestamp(7, bean.getCreatedDatetime());
	        pstmt.setTimestamp(8, bean.getModifiedDatetime(), null);

	        int i = pstmt.executeUpdate();
	        System.out.println("Course inserted = " + i);
	    }

	    public static void update(CourseBean bean) throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

	        PreparedStatement pstmt = conn.prepareStatement(
	            "UPDATE st_course SET name = ?, duration = ?, description = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ? WHERE id = ?"
	        );

	        pstmt.setString(1, bean.getName());
	        pstmt.setString(2, bean.getDuration());
	        pstmt.setString(3, bean.getDescription());
	        pstmt.setString(4, bean.getCreatedBy());
	        pstmt.setString(5, bean.getModifiedBy());
	        pstmt.setTimestamp(6, bean.getCreatedDatetime());
	        pstmt.setTimestamp(7, bean.getModifiedDatetime());
	        pstmt.setLong(8, bean.getId());

	        int i = pstmt.executeUpdate();
	        System.out.println("Course updated = " + i);
	    }

	    public static void delete(long id) throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

	        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM st_course WHERE id = ?");
	        pstmt.setLong(1, id);

	        int i = pstmt.executeUpdate();
	        System.out.println("Course deleted = " + i);
	    }

	    public CourseBean findByPk(long id) throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

	        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM st_course WHERE id = ?");
	        pstmt.setLong(1, id);
	        ResultSet rs = pstmt.executeQuery();

	        CourseBean bean = null;
	        if (rs.next()) {
	            bean = new CourseBean();
	            bean.setId(rs.getLong("id"));
	            bean.setName(rs.getString("name"));
	            bean.setDuration(rs.getString("duration"));
	            bean.setDescription(rs.getString("description"));
	            bean.setCreatedBy(rs.getString("created_by"));
	            bean.setModifiedBy(rs.getString("modified_by"));
	            bean.setCreatedDatetime(rs.getTimestamp("created_datetime"));
	            bean.setModifiedDatetime(rs.getTimestamp("modified_datetime"));
	        }

	        return bean;
	    }

	    public List<CourseBean> search(CourseBean bean, int pageNo, int pageSize) throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

	        StringBuffer sql = new StringBuffer("SELECT * FROM st_course WHERE 1=1");

	        if (bean != null) {
	            if (bean.getId() > 0) {
	                sql.append(" AND id = " + bean.getId());
	            }
	            if (bean.getName() != null && bean.getName().length() > 0) {
	                sql.append(" AND name LIKE '" + bean.getName() + "%'");
	            }
	        }

	        if (pageSize > 0) {
	            pageNo = (pageNo - 1) * pageSize;
	            sql.append(" LIMIT " + pageNo + ", " + pageSize);
	        }

	        System.out.println("SQL => " + sql);

	        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	        ResultSet rs = pstmt.executeQuery();

	        List<CourseBean> list = new ArrayList<>();

	        while (rs.next()) {
	            CourseBean cb = new CourseBean();
	            cb.setId(rs.getLong("id"));
	            cb.setName(rs.getString("name"));
	            cb.setDuration(rs.getString("duration"));
	            cb.setDescription(rs.getString("description"));
	            cb.setCreatedBy(rs.getString("created_by"));
	            cb.setModifiedBy(rs.getString("modified_by"));
	            cb.setCreatedDatetime(rs.getTimestamp("created_datetime"));
	            cb.setModifiedDatetime(rs.getTimestamp("modified_datetime"));
	            list.add(cb);
	        }

	        return list;
	    }
	}


