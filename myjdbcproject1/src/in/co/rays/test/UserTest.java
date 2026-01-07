package in.co.rays.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class UserTest {

	public static void main(String[] args) throws Exception {

		// testNextPk();

		testAdd();

		// testUpdate();

		// testDelete();

		// testFindByPk();

		// testFindByLoginId();

	}

	public static void testNextPk() throws Exception {

		UserModel model = new UserModel();

		int pk = model.nextPk();

		System.out.println("next primary key: " + pk);
	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		UserBean bean = new UserBean();

		bean.setFirstName("kavya");
		bean.setLastName("Gayakwad");
		bean.setLogin("kavyajiiii123");
		bean.setPassword("1234");
		bean.setDob(sdf.parse("01-01-2007"));
		bean.setMobilNO("91650658144");
		bean.setRoleId(2);
		bean.setGender("female");
		bean.setCreatedBy("Pranita");
		bean.setModifiedBy("Pranita");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		UserModel model = new UserModel();

		model.add(bean);
	}

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		UserBean bean = new UserBean();

		bean.setFirstName("siya");
		bean.setLastName("yadav");
		bean.setLogin("anaya@gmail.com");
		bean.setPassword("34569");
		bean.setConfirmPassword("34569");
		bean.setDob(sdf.parse("26-12-2000"));
		bean.setMobilNO("8100554445");
		bean.setRoleId(6);

		UserModel model = new UserModel();

		model.update(bean);
	}

	public static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(2);
	}

	public static void testFindByPk() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.findByPk(2);

		if (bean != null) {
			System.out.print(bean.getLogin());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());

		} else {
			System.out.println("user id not found");
		}
	}

	public static void testFindByLoginId() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.findByLoginId("kavya@gmail.com");

		if (bean != null) {
			System.out.print(bean.getLogin());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());

		} else {
			System.out.println("Login Id does not exist");
		}
	}
}
