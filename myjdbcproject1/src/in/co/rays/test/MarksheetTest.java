package in.co.rays.test;
	
	import java.text.SimpleDateFormat;
	import java.util.Iterator;
	import java.util.List;
	import in.co.rays.bean.MarksheetBean;
	import in.co.rays.model.MarksheetModel;

	public class MarksheetTest {
			
			 public static void main(String[] args) throws Exception {
			       // testNextPK();
			       // testAdd();
			       //  testUpdate();
			       //  testDelete();
			       //  testFindByPk();
			        //testSearch();
			    }

		    private static void testNextPK() throws Exception {
		   	 MarksheetModel model = new MarksheetModel();
				int Pk = model.nextPk();
				System.out.println("Next Primary Key : " + Pk);
				
			}

			public static void testAdd() throws Exception {
		        MarksheetBean bean = new MarksheetBean();
		        bean.setRollNo("1004");
		        bean.setStudentId(106L);
		        bean.setName("Pranita Gayakwad");
		        bean.setPhysics(76);
		        bean.setChemistry(29);
		        bean.setMaths(89);
		        bean.setCreatedBy("admin");
		        bean.setModifiedBy("admin");

		        MarksheetModel.add(bean);
		    }

		    public static void testUpdate() throws Exception {
		        MarksheetBean bean = new MarksheetBean();
		        bean.setId(1L);  // Make sure this ID exists in your DB
		        bean.setRollNo("RN001");
		        bean.setStudentId(106);
		        bean.setName("Rahul Sharma Updated");
		        bean.setPhysics(95);
		        bean.setChemistry(90);
		        bean.setMaths(85);
		        bean.setModifiedBy("admin");

		        MarksheetModel.update(bean);
		    }

		    public static void testDelete() throws Exception {
		        MarksheetModel.delete(4); 
		    }

		    public static void testFindByPk() throws Exception {
		        MarksheetModel model = new MarksheetModel();
		        MarksheetBean bean = model.findByPk(1);  // Replace with a valid ID
		        if (bean != null) {
		            System.out.println("ID: " + bean.getId());
		            System.out.println("Roll No: " + bean.getRollNo());
		            System.out.println("Name: " + bean.getName());
		            System.out.println("Physics: " + bean.getPhysics());
		            System.out.println("Chemistry: " + bean.getChemistry());
		            System.out.println("Maths: " + bean.getMaths());
		        } else {
		            System.out.println("Record Not Found");
		        }
		    }

		    public static void testSearch() throws Exception {
		        MarksheetBean searchBean = new MarksheetBean();
		        searchBean.setName("Rahul");

		        MarksheetModel model = new MarksheetModel();
		        List<MarksheetBean> list = model.search(searchBean, 1, 10);
		        Iterator<MarksheetBean> it = list.iterator();
		        while (it.hasNext()) {
		            MarksheetBean bean = it.next();
		            System.out.println("ID: " + bean.getId());
		            System.out.println("Roll No: " + bean.getRollNo());
		            System.out.println("Name: " + bean.getName());
		            System.out.println("Physics: " + bean.getPhysics());
		            System.out.println("Chemistry: " + bean.getChemistry());
		            System.out.println("Maths: " + bean.getMaths());
		            System.out.println("----------------------------------");
		        }
		    }	   
}

