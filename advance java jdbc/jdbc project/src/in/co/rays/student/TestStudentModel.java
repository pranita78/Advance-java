package in.co.rays.student;

import java.text.SimpleDateFormat;

public class TestStudentModel {
	
	public static void main(String[] args) throws Exception {
		
		//testNextPk();
		testAdd();
	}
	public static void  testNextPk()throws Exception{
		
		StudentModel model = new StudentModel();
		
		int pk = model.nextPk();
		
		System.out.println("next primary key: " + pk);
		
	}

	public static void  testAdd()throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		StudentBean bean = new StudentBean();
		
		bean.setFirstName("Pranita");
		bean.setLastName("Gayakwad");
		bean.setDob(sdf.parse("28-03-2004"));
		bean.setGender("Female");
		bean.setMobilno(916506814);
		bean.setEmail("pranita@gmail.com");
		bean.setCollegeName("Softvision");
       
		StudentModel model = new StudentModel();

		model.add(bean);
	          
		
		
	}


}
