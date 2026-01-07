package in.co.rays.model;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Timestamp;
	import java.util.ArrayList;
	import java.util.List;
	import in.co.rays.bean.TimetableBean;

		public class TimetableModel {

		    public static Integer nextPk() throws Exception {
		        int pk = 0;
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

		        PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(id) FROM st_timetable");
		        ResultSet rs = pstmt.executeQuery();

		        if (rs.next()) {
		            pk = rs.getInt(1) + 1;
		        }
		        return pk;
		    }

		    public static void add(TimetableBean bean) throws Exception {
		        int pk = nextPk();
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

		        PreparedStatement pstmt = conn.prepareStatement(
		            "INSERT INTO st_timetable (id, semester, description, exam_date, exam_time, course_id, course_name, subject_id, subject_name, created_by, modified_by, created_datetime, modified_datetime) " +
		            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())");

		        pstmt.setInt(1, pk);
		        pstmt.setString(2, bean.getSemester());
		        pstmt.setString(3, bean.getDescription());
		        pstmt.setTimestamp(4, (Timestamp) bean.getExamDate());
		        pstmt.setString(5, bean.getExamTime());
		        pstmt.setLong(6, bean.getCourseId());
		        pstmt.setString(7, bean.getCourseName());
		        pstmt.setLong(8, bean.getSubjectId());
		        pstmt.setString(9, bean.getSubjectName());
		        pstmt.setString(10, bean.getCreatedBy());
		        pstmt.setString(11, bean.getModifiedBy());

		        int i = pstmt.executeUpdate();
		        System.out.println("Timetable Inserted = " + i);
		    }

		    public static void update(TimetableBean bean) throws Exception {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

		        PreparedStatement pstmt = conn.prepareStatement(
		            "UPDATE st_timetable SET semester = ?, description = ?, exam_date = ?, exam_time = ?, course_id = ?, course_name = ?, subject_id = ?, subject_name = ?, modified_by = ?, modified_datetime = NOW() WHERE id = ?");

		        pstmt.setString(1, bean.getSemester());
		        pstmt.setString(2, bean.getDescription());
		        pstmt.setTimestamp(3, (Timestamp) bean.getExamDate());
		        pstmt.setString(4, bean.getExamTime());
		        pstmt.setLong(5, bean.getCourseId());
		        pstmt.setString(6, bean.getCourseName());
		        pstmt.setLong(7, bean.getSubjectId());
		        pstmt.setString(8, bean.getSubjectName());
		        pstmt.setString(9, bean.getModifiedBy());
		        pstmt.setLong(10, bean.getId());

		        int i = pstmt.executeUpdate();
		        System.out.println("Timetable Updated = " + i);
		    }

		    public static void delete(long id) throws Exception {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

		        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM st_timetable WHERE id = ?");
		        pstmt.setLong(1, id);

		        int i = pstmt.executeUpdate();
		        System.out.println("Timetable Deleted = " + i);
		    }

		    public TimetableBean findByPk(long id) throws Exception {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

		        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM st_timetable WHERE id = ?");
		        pstmt.setLong(1, id);
		        ResultSet rs = pstmt.executeQuery();

		        TimetableBean bean = null;
		        if (rs.next()) {
		            bean = new TimetableBean();
		            bean.setId(rs.getLong("id"));
		            bean.setSemester(rs.getString("semester"));
		            bean.setDescription(rs.getString("description"));
		            bean.setExamDate(rs.getTimestamp("exam_date"));
		            bean.setExamTime(rs.getString("exam_time"));
		            bean.setCourseId(rs.getLong("course_id"));
		            bean.setCourseName(rs.getString("course_name"));
		            bean.setSubjectId(rs.getLong("subject_id"));
		            bean.setSubjectName(rs.getString("subject_name"));
		            bean.setCreatedBy(rs.getString("created_by"));
		            bean.setModifiedBy(rs.getString("modified_by"));
		            bean.setCreatedDatetime(rs.getTimestamp("created_datetime"));
		            bean.setModifiedDatetime(rs.getTimestamp("modified_datetime"));
		        }

		        return bean;
		    }

		    public List<TimetableBean> search(TimetableBean bean, int pageNo, int pageSize) throws Exception {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");

		        StringBuffer sql = new StringBuffer("SELECT * FROM st_timetable WHERE 1=1");

		        if (bean != null) {
		            if (bean.getSemester() != null && bean.getSemester().length() > 0) {
		                sql.append(" AND semester LIKE '" + bean.getSemester() + "%'");
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

		        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		        ResultSet rs = pstmt.executeQuery();

		        List<TimetableBean> list = new ArrayList<>();

		        while (rs.next()) {
		            TimetableBean tBean = new TimetableBean();
		            tBean.setId(rs.getLong("id"));
		            tBean.setSemester(rs.getString("semester"));
		            tBean.setDescription(rs.getString("description"));
		            tBean.setExamDate(rs.getTimestamp("exam_date"));
		            tBean.setExamTime(rs.getString("exam_time"));
		            tBean.setCourseId(rs.getLong("course_id"));
		            tBean.setCourseName(rs.getString("course_name"));
		            tBean.setSubjectId(rs.getLong("subject_id"));
		            tBean.setSubjectName(rs.getString("subject_name"));
		            tBean.setCreatedBy(rs.getString("created_by"));
		            tBean.setModifiedBy(rs.getString("modified_by"));
		            tBean.setCreatedDatetime(rs.getTimestamp("created_datetime"));
		            tBean.setModifiedDatetime(rs.getTimestamp("modified_datetime"));

		            list.add(tBean);
		        }

		        return list;
		    }
}


