package in.co.rays.test;
	

	import java.text.SimpleDateFormat;
	import java.util.Iterator;
	import java.util.List;
	import in.co.rays.bean.FacultyBean;
	import in.co.rays.model.FacultyModel;

		public class TestFacultyModel {

		    public static void main(String[] args) throws Exception {
		         //testNextPk();
		       // testAdd();
		      //  testUpdate();
		        // testDelete();
		        //testFindByPk();
		         testSearch();
		    }

		    public static void testNextPk() throws Exception {
		        int pk = FacultyModel.nextPk();
		        System.out.println("Next Primary Key: " + pk);
		    }

		    public static void testAdd() throws Exception {
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		        FacultyBean bean = new FacultyBean();
		        bean.setFirstName("Yuvraj");
		        bean.setLastName("Rathore");
		        bean.setDob(sdf.parse("2000-05-14"));
		        bean.setGender("Male");
		        bean.setMobileNo("9876543210");
		        bean.setEmail("yuvraj.rathore@example.com");
		        bean.setCollegeId(6L);
		        bean.setCollegeName("Delhi Engineering College");
		        bean.setCourseId(106L);
		        bean.setCourseName("B.Tech Computer Science");
		        bean.setSubjectId(206L);
		        bean.setSubjectName("Data Structures");
		        bean.setCreatedBy("admin");
		        bean.setModifiedBy("admin");

		        FacultyModel.add(bean);
		    }

		    public static void testUpdate() throws Exception {
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		        FacultyBean bean = new FacultyBean();
		        bean.setId(1L); 
		        bean.setFirstName("Kavya");
		        bean.setLastName("Gayakwad");
		        bean.setDob(sdf.parse("2004-05-19"));
		        bean.setGender("Female");
		        bean.setMobileNo("9165877147");
		        bean.setEmail("kavya@email.com");
		        bean.setCollegeId(2L);
		        bean.setCollegeName("Davv University");
		        bean.setCourseId(102L);
		        bean.setCourseName("MBA");
		        bean.setSubjectId(202L);
		        bean.setSubjectName("Busniess Organization");
		        bean.setModifiedBy("author");

		        FacultyModel.update(bean);
		    }

		    public static void testDelete() throws Exception {
		        FacultyModel.delete(4); 
		    }

		    public static void testFindByPk() throws Exception {
		        FacultyModel model = new FacultyModel();
		        FacultyBean bean = model.findByPk(1L);

		        if (bean != null) {
		            System.out.println("ID: " + bean.getId());
		            System.out.println("First Name: " + bean.getFirstName());
		            System.out.println("Last Name: " + bean.getLastName());
		            System.out.println("DOB: " + bean.getDob());
		            System.out.println("Gender: " + bean.getGender());
		            System.out.println("Mobile No: " + bean.getMobileNo());
		            System.out.println("Email: " + bean.getEmail());
		            System.out.println("College ID: " + bean.getCollegeId());
		            System.out.println("College Name: " + bean.getCollegeName());
		            System.out.println("Course ID: " + bean.getCourseId());
		            System.out.println("Course Name: " + bean.getCourseName());
		            System.out.println("Subject ID: " + bean.getSubjectId());
		            System.out.println("Subject Name: " + bean.getSubjectName());
		            System.out.println("Created By: " + bean.getCreatedBy());
		            System.out.println("Modified By: " + bean.getModifiedBy());
		            System.out.println("Created Datetime: " + bean.getCreatedDatetime());
		            System.out.println("Modified Datetime: " + bean.getModifiedDatetime());
		        } else {
		            System.out.println("Record not found");
		        }
		    }

		    public static void testSearch() throws Exception {
		        FacultyBean searchBean = new FacultyBean();
		        searchBean.setFirstName("Yuvraj      ");

		        FacultyModel model = new FacultyModel();
		        List<FacultyBean> list = model.search(searchBean, 1, 10);
		        Iterator<FacultyBean> it = list.iterator();

		        while (it.hasNext()) {
		            FacultyBean bean = it.next();
		            System.out.println("ID: " + bean.getId());
		            System.out.println("First Name: " + bean.getFirstName());
		            System.out.println("Last Name: " + bean.getLastName());
		            System.out.println("Email: " + bean.getEmail());
		            System.out.println("Mobile No: " + bean.getMobileNo());
		            System.out.println("Gender: " + bean.getGender());
		            System.out.println("Course Name: " + bean.getCourseName());
		            System.out.println("Subject Name: " + bean.getSubjectName());
		            System.out.println("College Name: " + bean.getCollegeName());
		            System.out.println("----------------------------------------");
		        }
		    }
	}


