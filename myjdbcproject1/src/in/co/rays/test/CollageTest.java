package in.co.rays.test;

	
	import java.util.Iterator;
	import java.util.List;

	import in.co.rays.bean.CollegeBean;
	import in.co.rays.model.CollegeModel;

	public class CollageTest {

	    public static void testAdd() throws Exception {
	        CollegeBean bean = new CollegeBean();
	        bean.setName("IET DAVV");
	        bean.setAddress("Khandwa Road, Indore");
	        bean.setState("Madhya Pradesh");
	        bean.setCity("Indore");
	        bean.setPhoneNo("07312470232");

	        CollegeModel.add(bean);
	        System.out.println("✅ Add test completed.");
	    }

	    public static void testUpdate() throws Exception {
	        CollegeBean bean = new CollegeBean();
	        bean.setId(1); // Set existing college ID here
	        bean.setName("IPS Academy");
	        bean.setAddress("Rajendra Nagar, Indore");
	        bean.setState("Madhya Pradesh");
	        bean.setCity("Indore");
	        bean.setPhoneNo("07312401407");

	        CollegeModel.update(bean);
	        System.out.println("✅ Update test completed.");
	    }

	    public static void testDelete() throws Exception {
	        int idToDelete = 2; // Set existing college ID here
	        CollegeModel.delete(idToDelete);
	        System.out.println("✅ Delete test completed.");
	    }

	    public static void testFindByPk() throws Exception {
	        int pk = 1; // Set existing college ID here
	        CollegeBean bean = new CollegeModel().findByPk(pk);

	        if (bean != null) {
	            System.out.println("College Found:");
	            System.out.println("ID: " + bean.getId());
	            System.out.println("Name: " + bean.getName());
	            System.out.println("Address: " + bean.getAddress());
	            System.out.println("State: " + bean.getState());
	            System.out.println("City: " + bean.getCity());
	            System.out.println("Phone No: " + bean.getPhoneNo());
	        } else {
	            System.out.println("❌ College not found.");
	        }
	    }

	    public static void testSearch() throws Exception {
	        CollegeBean bean = new CollegeBean();
	        bean.setName("I"); // Partial name to match "IET", "IPS", etc.

	        List<CollegeBean> list = new CollegeModel().search(bean, 1, 10);
	        Iterator<CollegeBean> it = list.iterator();

	        while (it.hasNext()) {
	            bean = it.next();
	            System.out.println("ID: " + bean.getId());
	            System.out.println("Name: " + bean.getName());
	            System.out.println("Address: " + bean.getAddress());
	            System.out.println("State: " + bean.getState());
	            System.out.println("City: " + bean.getCity());
	            System.out.println("Phone No: " + bean.getPhoneNo());
	            System.out.println("------------------------------");
	        }

	        if (list.size() == 0) {
	            System.out.println("❌ No matching colleges found.");
	        }
	    }

	    public static void main(String[] args) throws Exception {
	        // Uncomment methods one by one to test individually

	        testAdd();
	        // testUpdate();
	        // testDelete();
	        // testFindByPk();
	        // testSearch();
	    }
	}


