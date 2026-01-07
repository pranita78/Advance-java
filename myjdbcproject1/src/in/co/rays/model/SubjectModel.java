package in.co.rays.model;


	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

	import in.co.rays.bean.SubjectBean;

	public class SubjectModel {

	    public static Integer nextPk() throws Exception {
	        int pk = 0;
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
	        PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(id) FROM st_subject");
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            pk = rs.getInt(1) + 1;
	        }
	        return pk;
	    }

	    public static void add(SubjectBean bean) throws Exception {
	        int pk = nextPk();
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

	        PreparedStatement pstmt = conn.prepareStatement(
	            "INSERT INTO st_subject (id, name, course_id, course_name, description, created_by, modified_by, created_datetime, modified_datetime) " +
	            "VALUES (?, ?, ?, ?, ?, ?, ?, NOW(), NOW())");

	        pstmt.setInt(1, pk);
	        pstmt.setString(2, bean.getName());
	        pstmt.setLong(3, bean.getCourseId());
	        pstmt.setString(4, bean.getCourseName());
	        pstmt.setString(5, bean.getDescription());
	        pstmt.setString(6, bean.getCreatedBy());
	        pstmt.setString(7, bean.getModifiedBy());

	        int i = pstmt.executeUpdate();
	        System.out.println("Subject Inserted = " + i);
	    }

	    public static void update(SubjectBean bean) throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

	        PreparedStatement pstmt = conn.prepareStatement(
	            "UPDATE st_subject SET name=?, course_id=?, course_name=?, description=?, modified_by=?, modified_datetime=NOW() WHERE id=?");

	        pstmt.setString(1, bean.getName());
	        pstmt.setLong(2, bean.getCourseId());
	        pstmt.setString(3, bean.getCourseName());
	        pstmt.setString(4, bean.getDescription());
	        pstmt.setString(5, bean.getModifiedBy());
	        pstmt.setInt(6, (int) bean.getId());

	        int i = pstmt.executeUpdate();
	        System.out.println("Subject Updated = " + i);
	    }

	    public static void delete(int id) throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

	        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM st_subject WHERE id = ?");
	        pstmt.setInt(1, id);

	        int i = pstmt.executeUpdate();
	        System.out.println("Subject Deleted = " + i);
	    }

	    public SubjectBean findByPk(int id) throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

	        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM st_subject WHERE id = ?");
	        pstmt.setInt(1, id);

	        ResultSet rs = pstmt.executeQuery();
	        SubjectBean bean = null;

	        if (rs.next()) {
	            bean = new SubjectBean();
	            bean.setId(rs.getInt("id"));
	            bean.setName(rs.getString("name"));
	            bean.setCourseId(rs.getLong("course_id"));
	            bean.setCourseName(rs.getString("course_name"));
	            bean.setDescription(rs.getString("description"));
	            bean.setCreatedBy(rs.getString("created_by"));
	            bean.setModifiedBy(rs.getString("modified_by"));
	            bean.setCreatedDatetime(rs.getTimestamp("created_datetime"));
	            bean.setModifiedDatetime(rs.getTimestamp("modified_datetime"));
	        }

	        return bean;
	    }

	    public List<SubjectBean> search(SubjectBean bean, int pageNo, int pageSize) throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

	        StringBuffer sql = new StringBuffer("SELECT * FROM st_subject WHERE 1=1");

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

	        List<SubjectBean> list = new ArrayList<>();

	        while (rs.next()) {
	            bean = new SubjectBean();
	            bean.setId(rs.getInt("id"));
	            bean.setName(rs.getString("name"));
	            bean.setCourseId(rs.getLong("course_id"));
	            bean.setCourseName(rs.getString("course_name"));
	            bean.setDescription(rs.getString("description"));
	            bean.setCreatedBy(rs.getString("created_by"));
	            bean.setModifiedBy(rs.getString("modified_by"));
	            bean.setCreatedDatetime(rs.getTimestamp("created_datetime"));
	            bean.setModifiedDatetime(rs.getTimestamp("modified_datetime"));
	            list.add(bean);
	        }

	        return list;
	    }
	}

