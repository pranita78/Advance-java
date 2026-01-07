package in.co.rays.test;

	import java.sql.Timestamp;
	import java.util.Iterator;
	import java.util.List;
	import in.co.rays.bean.TimetableBean;
	import in.co.rays.model.TimetableModel;

		public class TimeTableTest {

		    public static void main(String[] args) throws Exception {
		       // testNextPk();
		         //testAdd();
		       //  testUpdate();
		      //   testDelete();
		       //  testFindByPk();
		         testSearch();
		    }

		    public static void testNextPk() throws Exception {
		        int pk = TimetableModel.nextPk();
		        System.out.println("Next Primary Key: " + pk);
		    }

		    public static void testAdd() throws Exception {
		        TimetableBean bean = new TimetableBean();
		        bean.setSemester("Semester 1");
		        bean.setDescription("First semester mid-term exam");
		        bean.setExamDate(Timestamp.valueOf("2025-08-15 00:00:00"));
		        bean.setExamTime("10:00 AM");
		        bean.setCourseId(101L);
		        bean.setCourseName("B.Tech Computer Science");
		        bean.setSubjectId(201L);
		        bean.setSubjectName("Data Structures");
		        bean.setCreatedBy("admin");
		        bean.setModifiedBy("admin");

		        TimetableModel.add(bean);
		    }

		    public static void testUpdate() throws Exception {
		        TimetableBean bean = new TimetableBean();
		        bean.setId(1L); 
		        bean.setSemester("Semester 2");
		        bean.setDescription("Updated Exam Info");
		        bean.setExamDate(Timestamp.valueOf("2025-09-15 00:00:00"));
		        bean.setExamTime("02:00 PM");
		        bean.setCourseId(101L);
		        bean.setCourseName("B.Tech Computer Science");
		        bean.setSubjectId(202L);
		        bean.setSubjectName("Operating Systems");
		        bean.setModifiedBy("editor");

		        TimetableModel.update(bean);
		    }

		    public static void testDelete() throws Exception {
		        TimetableModel.delete(3); 
		    }

		    public static void testFindByPk() throws Exception {
		        TimetableModel model = new TimetableModel();
		        TimetableBean bean = model.findByPk(1L);

		        if (bean != null) {
		            System.out.println("ID: " + bean.getId());
		            System.out.println("Semester: " + bean.getSemester());
		            System.out.println("Description: " + bean.getDescription());
		            System.out.println("Exam Date: " + bean.getExamDate());
		            System.out.println("Exam Time: " + bean.getExamTime());
		            System.out.println("Course ID: " + bean.getCourseId());
		            System.out.println("Course Name: " + bean.getCourseName());
		            System.out.println("Subject ID: " + bean.getSubjectId());
		            System.out.println("Subject Name: " + bean.getSubjectName());
		            System.out.println("Created By: " + bean.getCreatedBy());
		            System.out.println("Modified By: " + bean.getModifiedBy());
		        } else {
		            System.out.println("Record not found");
		        }
		    }

		    public static void testSearch() throws Exception {
		        TimetableBean searchBean = new TimetableBean();
		        searchBean.setCourseName("B.Tech");

		        TimetableModel model = new TimetableModel();
		        List<TimetableBean> list = model.search(searchBean, 1, 10);
		        Iterator<TimetableBean> it = list.iterator();

		        while (it.hasNext()) {
		            TimetableBean bean = it.next();
		            System.out.println("ID: " + bean.getId());
		            System.out.println("Semester: " + bean.getSemester());
		            System.out.println("Description: " + bean.getDescription());
		            System.out.println("Exam Date: " + bean.getExamDate());
		            System.out.println("Exam Time: " + bean.getExamTime());
		            System.out.println("Course ID: " + bean.getCourseId());
		            System.out.println("Course Name: " + bean.getCourseName());
		            System.out.println("Subject ID: " + bean.getSubjectId());
		            System.out.println("Subject Name: " + bean.getSubjectName());
		            System.out.println("------------------------------------------------");
		        }
		   }
}
