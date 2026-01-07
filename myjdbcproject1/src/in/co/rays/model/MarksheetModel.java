package in.co.rays.model;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

	import in.co.rays.bean.MarksheetBean;

	public class MarksheetModel  {

		    public static Integer nextPk() throws Exception {
		        int pk = 0;
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
		        PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(id) FROM st_marksheet");
		        ResultSet rs = pstmt.executeQuery();
		        if (rs.next()) {
		            pk = rs.getInt(1) + 1;
		        }
		        return pk;
		    }

		    public static void add(MarksheetBean bean) throws Exception {
		        int pk = nextPk();
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

		        PreparedStatement pstmt = conn.prepareStatement(
		            "INSERT INTO st_marksheet (id, roll_no, student_id, name, physics, chemistry, maths, created_by, modified_by, created_datetime, modified_datetime) "
		            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())"
		        );

		        pstmt.setInt(1, pk);
		        pstmt.setString(2, bean.getRollNo());
		        pstmt.setLong(3, bean.getStudentId());
		        pstmt.setString(4, bean.getName());
		        pstmt.setInt(5, bean.getPhysics());
		        pstmt.setInt(6, bean.getChemistry());
		        pstmt.setInt(7, bean.getMaths());
		        pstmt.setString(8, bean.getCreatedBy());
		        pstmt.setString(9, bean.getModifiedBy());

		        int i = pstmt.executeUpdate();
		        System.out.println("Marksheet Inserted = " + i);
		    }

		    public static void update(MarksheetBean bean) throws Exception {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

		        PreparedStatement pstmt = conn.prepareStatement(
		            "UPDATE st_marksheet SET roll_no = ?, student_id = ?, name = ?, physics = ?, chemistry = ?, maths = ?, modified_by = ?, modified_datetime = NOW() WHERE id = ?"
		        );

		        pstmt.setString(1, bean.getRollNo());
		        pstmt.setLong(2, bean.getStudentId());
		        pstmt.setString(3, bean.getName());
		        pstmt.setInt(4, bean.getPhysics());
		        pstmt.setInt(5, bean.getChemistry());
		        pstmt.setInt(6, bean.getMaths());
		        pstmt.setString(7, bean.getModifiedBy());
		        pstmt.setLong(8, bean.getId());

		        int i = pstmt.executeUpdate();
		        System.out.println("Marksheet Updated = " + i);
		    }

		    public static void delete(long id) throws Exception {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

		        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM st_marksheet WHERE id = ?");
		        pstmt.setLong(1, id);

		        int i = pstmt.executeUpdate();
		        System.out.println("Marksheet Deleted = " + i);
		    }

		    public MarksheetBean findByPk(long id) throws Exception {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

		        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM st_marksheet WHERE id = ?");
		        pstmt.setLong(1, id);
		        ResultSet rs = pstmt.executeQuery();

		        MarksheetBean bean = null;
		        if (rs.next()) {
		            bean = new MarksheetBean();
		            bean.setId(rs.getLong("id"));
		            bean.setRollNo(rs.getString("roll_no"));
		            bean.setStudentId(rs.getLong("student_id"));
		            bean.setName(rs.getString("name"));
		            bean.setPhysics(rs.getInt("physics"));
		            bean.setChemistry(rs.getInt("chemistry"));
		            bean.setMaths(rs.getInt("maths"));
		            bean.setCreatedBy(rs.getString("created_by"));
		            bean.setModifiedBy(rs.getString("modified_by"));
		            bean.setCreatedDatetime(rs.getTimestamp("created_datetime"));
		            bean.setModifiedDatetime(rs.getTimestamp("modified_datetime"));
		        }

		        return bean;
		    }

		    public List<MarksheetBean> search(MarksheetBean bean, int pageNo, int pageSize) throws Exception {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

		        StringBuffer sql = new StringBuffer("SELECT * FROM st_marksheet WHERE 1=1");

		        if (bean != null) {
		            if (bean.getRollNo() != null && bean.getRollNo().length() > 0) {
		                sql.append(" AND roll_no LIKE '" + bean.getRollNo() + "%'");
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

		        List<MarksheetBean> list = new ArrayList<>();

		        while (rs.next()) {
		            bean = new MarksheetBean();
		            bean.setId(rs.getLong("id"));
		            bean.setRollNo(rs.getString("roll_no"));
		            bean.setStudentId(rs.getLong("student_id"));
		            bean.setName(rs.getString("name"));
		            bean.setPhysics(rs.getInt("physics"));
		            bean.setChemistry(rs.getInt("chemistry"));
		            bean.setMaths(rs.getInt("maths"));
		            bean.setCreatedBy(rs.getString("created_by"));
		            bean.setModifiedBy(rs.getString("modified_by"));
		            bean.setCreatedDatetime(rs.getTimestamp("created_datetime"));
		            bean.setModifiedDatetime(rs.getTimestamp("modified_datetime"));

		            list.add(bean);
		        }

		        return list;
		    }
}

