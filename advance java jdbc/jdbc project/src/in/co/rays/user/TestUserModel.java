package in.co.rays.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import in.co.rays.dynamic.TestUpdateDynamic;
import in.co.rays.pstmt.TestDelete;

public class TestUserModel {
	
	public static void main(String[] args)throws Exception {
		
		//testNextPk();
		//testAdd();
		//testUpdate();
		//testDelete();
		//testFindByPk();
		testFindByLoginId();
		
			}
			 


		public static void testNextPk() throws Exception {
		
		UserModel model = new UserModel();
		int  pk  = model.nextPk();
		System.out.println("next primary key:" + pk);
	}
	
	public static void testAdd () throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		UserModel model = new UserModel();
		
		UserBean bean = new UserBean();
		bean.setFirstName("Pranita");
		bean.setLastName("Gayakwad");
		bean.setLoginId("pranita@gmail.com");
		bean.setPassword("123");
		bean.setDob(sdf.parse("28-03-2004") );
		bean.setAddress("Indore");
		
		model.add(bean);
		
	}
	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		UserBean bean = new UserBean();

		bean.setId(11);
		bean.setFirstName("Pranita");
		bean.setLastName("Gayakwad");
		bean.setLoginId("pranita@gmail.com");
		bean.setPassword("1234");
		bean.setDob(sdf.parse("28-03-2004"));
		bean.setAddress("Indore");
		
		UserModel model = new UserModel();
		model.Update(bean);

	}
	public static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(10);
	}
	public static void testFindByPk() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.findByPk(2);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());
		} else {
			System.out.println("user id not found");
		}
		
		
		
	}
	public static void testFindByLoginId() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.findByLoginId("pranita@gmail.com");

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());
		} else {
			System.out.println("Login Id does not exist");
		}
	}
}
	
	


	 