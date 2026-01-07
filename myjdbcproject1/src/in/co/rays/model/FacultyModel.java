package in.co.rays.model;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Timestamp;
	import java.util.ArrayList;
	import java.util.List;
	import in.co.rays.bean.FacultyBean;

	public class FacultyModel {

	    public static Integer nextPk() throws Exception {
	        int pk = 0;
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
	             PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(id) FROM st_faculty");
	             ResultSet rs = pstmt.executeQuery()) {

	            if (rs.next()) {
	                pk = rs.getInt(1) + 1;
	            }
	        }
	        return pk;
	    }

	    public static void add(FacultyBean bean) throws Exception {
	        int pk = nextPk();
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
	             PreparedStatement pstmt = conn.prepareStatement(
	                 "INSERT INTO st_faculty (id, first_name, last_name, dob, gender, mobile_no, email, college_id, college_name, course_id, course_name, subject_id, subject_name, created_by, modified_by, created_datetime, modified_datetime) " +
	                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())")) {

	            pstmt.setInt(1, pk);
	            pstmt.setString(2, bean.getFirstName());
	            pstmt.setString(3, bean.getLastName());
	            pstmt.setTimestamp(4, new Timestamp(bean.getDob().getTime()));
	            pstmt.setString(5, bean.getGender());
	            pstmt.setString(6, bean.getMobileNo());
	            pstmt.setString(7, bean.getEmail());
	            pstmt.setLong(8, bean.getCollegeId());
	            pstmt.setString(9, bean.getCollegeName());
	            pstmt.setLong(10, bean.getCourseId());
	            pstmt.setString(11, bean.getCourseName());
	            pstmt.setLong(12, bean.getSubjectId());
	            pstmt.setString(13, bean.getSubjectName());
	            pstmt.setString(14, bean.getCreatedBy());
	            pstmt.setString(15, bean.getModifiedBy());

	            int i = pstmt.executeUpdate();
	            System.out.println("Faculty Inserted = " + i);
	        }
	    }

	    public static void update(FacultyBean bean) throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
	             PreparedStatement pstmt = conn.prepareStatement(
	                 "UPDATE st_faculty SET first_name = ?, last_name = ?, dob = ?, gender = ?, mobile_no = ?, email = ?, college_id = ?, college_name = ?, course_id = ?, course_name = ?, subject_id = ?, subject_name = ?, modified_by = ?, modified_datetime = NOW() WHERE id = ?")) {

	            pstmt.setString(1, bean.getFirstName());
	            pstmt.setString(2, bean.getLastName());
	            pstmt.setTimestamp(3, new Timestamp(bean.getDob().getTime()));
	            pstmt.setString(4, bean.getGender());
	            pstmt.setString(5, bean.getMobileNo());
	            pstmt.setString(6, bean.getEmail());
	            pstmt.setLong(7, bean.getCollegeId());
	            pstmt.setString(8, bean.getCollegeName());
	            pstmt.setLong(9, bean.getCourseId());
	            pstmt.setString(10, bean.getCourseName());
	            pstmt.setLong(11, bean.getSubjectId());
	            pstmt.setString(12, bean.getSubjectName());
	            pstmt.setString(13, bean.getModifiedBy());
	            pstmt.setLong(14, bean.getId());

	            int i = pstmt.executeUpdate();
	            System.out.println("Faculty Updated = " + i);
	        }
	    }

	    public static void delete(long id) throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
	             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM st_faculty WHERE id = ?")) {

	            pstmt.setLong(1, id);
	            int i = pstmt.executeUpdate();
	            System.out.println("Faculty Deleted = " + i);
	        }
	    }

	    public FacultyBean findByPk(long id) throws Exception {
	        FacultyBean bean = null;
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
	             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM st_faculty WHERE id = ?")) {

	            pstmt.setLong(1, id);
	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    bean = new FacultyBean();
	                    bean.setId(rs.getLong("id"));
	                    bean.setFirstName(rs.getString("first_name"));
	                    bean.setLastName(rs.getString("last_name"));
	                    bean.setDob(rs.getTimestamp("dob"));
	                    bean.setGender(rs.getString("gender"));
	                    bean.setMobileNo(rs.getString("mobile_no"));
	                    bean.setEmail(rs.getString("email"));
	                    bean.setCollegeId(rs.getLong("college_id"));
	                    bean.setCollegeName(rs.getString("college_name"));
	                    bean.setCourseId(rs.getLong("course_id"));
	                    bean.setCourseName(rs.getString("course_name"));
	                    bean.setSubjectId(rs.getLong("subject_id"));
	                    bean.setSubjectName(rs.getString("subject_name"));
	                    bean.setCreatedBy(rs.getString("created_by"));
	                    bean.setModifiedBy(rs.getString("modified_by"));
	                    bean.setCreatedDatetime(rs.getTimestamp("created_datetime"));
	                    bean.setModifiedDatetime(rs.getTimestamp("modified_datetime"));
	                }
	            }
	        }
	        return bean;
	    }

	    public List<FacultyBean> search(FacultyBean bean, int pageNo, int pageSize) throws Exception {
	        List<FacultyBean> list = new ArrayList<>();
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root")) {

	            StringBuffer sql = new StringBuffer("SELECT * FROM st_faculty WHERE 1=1");

	            if (bean != null) {
	                if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
	                    sql.append(" AND first_name LIKE '" + bean.getFirstName() + "%'");
	                }
	                if (bean.getLastName() != null && bean.getLastName().length() > 0) {
	                    sql.append(" AND last_name LIKE '" + bean.getLastName() + "%'");
	                }
	                if (bean.getEmail() != null && bean.getEmail().length() > 0) {
	                    sql.append(" AND email LIKE '" + bean.getEmail() + "%'");
	                }
	                if (bean.getGender() != null && bean.getGender().length() > 0) {
	                    sql.append(" AND gender = '" + bean.getGender() + "'");
	                }
	                if (bean.getCollegeName() != null && bean.getCollegeName().length() > 0) {
	                    sql.append(" AND college_name LIKE '" + bean.getCollegeName() + "%'");
	                }
	                if (bean.getCourseName() != null && bean.getCourseName().length() > 0) {
	                    sql.append(" AND course_name LIKE '" + bean.getCourseName() + "%'");
	                }
	                if (bean.getSubjectName() != null && bean.getSubjectName().length() > 0) {
	                    sql.append(" AND subject_name LIKE '" + bean.getSubjectName() + "%'");
	                }
	            }

	            if (pageSize > 0) {
	                pageNo = (pageNo - 1) * pageSize;
	                sql.append(" LIMIT " + pageNo + ", " + pageSize);
	            }

	            System.out.println("SQL => " + sql);

	            try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	                 ResultSet rs = pstmt.executeQuery()) {

	                while (rs.next()) {
	                    FacultyBean fBean = new FacultyBean();
	                    fBean.setId(rs.getLong("id"));
	                    fBean.setFirstName(rs.getString("first_name"));
	                    fBean.setLastName(rs.getString("last_name"));
	                    fBean.setDob(rs.getTimestamp("dob"));
	                    fBean.setGender(rs.getString("gender"));
	                    fBean.setMobileNo(rs.getString("mobile_no"));
	                    fBean.setEmail(rs.getString("email"));
	                    fBean.setCollegeId(rs.getLong("college_id"));
	                    fBean.setCollegeName(rs.getString("college_name"));
	                    fBean.setCourseId(rs.getLong("course_id"));
	                    fBean.setCourseName(rs.getString("course_name"));
	                    fBean.setSubjectId(rs.getLong("subject_id"));
	                    fBean.setSubjectName(rs.getString("subject_name"));
	                    fBean.setCreatedBy(rs.getString("created_by"));
	                    fBean.setModifiedBy(rs.getString("modified_by"));
	                    fBean.setCreatedDatetime(rs.getTimestamp("created_datetime"));
	                    fBean.setModifiedDatetime(rs.getTimestamp("modified_datetime"));

	                    list.add(fBean);
	                }
	            }
	        }
	        return list;
	    }
}

