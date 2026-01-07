	package in.co.rays.test;

	import java.sql.Date;
	import java.util.List;
	import in.co.rays.bean.StudentBean;
	import in.co.rays.model.StudentModel;

	public class StudentTest {

	    public static void main(String[] args) throws Exception {
	        testAdd();
	        // testUpdate();
	        // testDelete();
	        // testFindByPk();
	        // testSearch();
	    }

	    public static void testAdd() throws Exception {
	        StudentBean bean = new StudentBean();
	        bean.setFirstName("Pranita");
	        bean.setLastName("Gayakwad");
	        bean.setDob(Date.valueOf("2004-04-15")); 
	        bean.setGender("female");
	        bean.setMobileNo("9165068147");
	        bean.setEmail("pranitagayakwad@gmail.com");
	        bean.setCollegeId(1l);
	        bean.setCollegeName("Softvision College");

	        bean.setCreatedBy("admin");
	        bean.setModifiedBy("admin");

	        StudentModel.add(bean);

	        System.out.println("Student added successfully.");
	    }

	    public static void testUpdate() throws Exception {
	        StudentBean bean = new StudentBean();
	        bean.setId(1); 

	        bean.setFirstName("John");
	        bean.setLastName("Smith");
	        bean.setDob(Date.valueOf("2000-01-15"));
	        bean.setGender("Male");
	        bean.setMobileNo("9876543211");
	        bean.setEmail("john.smith@example.com");
	        bean.setCollegeId(1L);
	        bean.setCollegeName("ABC College");

	        bean.setModifiedBy("admin");

	        StudentModel.update(bean);

	        System.out.println("Student updated successfully.");
	    }

	    public static void testDelete() throws Exception {
	        long idToDelete = 1; 
	        StudentModel.delete(idToDelete);
	        System.out.println("Student deleted successfully.");
	    }

	    public static void testFindByPk() throws Exception {
	        long pk = 1; 
	        StudentBean bean = new StudentModel().findByPk(pk);

	        if (bean != null) {
	            System.out.println("Student Found:");
	            System.out.println("ID: " + bean.getId());
	            System.out.println("First Name: " + bean.getFirstName());
	            System.out.println("Last Name: " + bean.getLastName());
	            System.out.println("DOB: " + bean.getDob());
	            System.out.println("Gender: " + bean.getGender());
	            System.out.println("Mobile No: " + bean.getMobileNo());
	            System.out.println("Email: " + bean.getEmail());
	            System.out.println("College ID: " + bean.getCollegeId());
	            System.out.println("College Name: " + bean.getCollegeName());
	            System.out.println("Created By: " + bean.getCreatedBy());
	            System.out.println("Modified By: " + bean.getModifiedBy());
	        } else {
	            System.out.println("Student not found.");
	        }
	    }

	    public static void testSearch() throws Exception {
	        StudentBean searchBean = new StudentBean();
	        searchBean.setFirstName("Jo"); 

	        List<StudentBean> list = new StudentModel().search(searchBean, 1, 10);

	        if (list.size() == 0) {
	            System.out.println("No matching students found.");
	            return;
	        }

	        for (StudentBean bean : list) {
	            System.out.println("ID: " + bean.getId());
	            System.out.println("First Name: " + bean.getFirstName());
	            System.out.println("Last Name: " + bean.getLastName());
	            System.out.println("DOB: " + bean.getDob());
	            System.out.println("Gender: " + bean.getGender());
	            System.out.println("Mobile No: " + bean.getMobileNo());
	            System.out.println("Email: " + bean.getEmail());
	            System.out.println("College ID: " + bean.getCollegeId());
	            System.out.println("College Name: " + bean.getCollegeName());
	            System.out.println("-----------------------------");
	        }
	    }
	}

}
