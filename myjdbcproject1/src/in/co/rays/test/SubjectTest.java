package in.co.rays.test;

	
	import java.util.Iterator;
	import java.util.List;

	import in.co.rays.bean.SubjectBean;
	import in.co.rays.model.SubjectModel;

	public class SubjectTest {
		
		 public static void main(String[] args) throws Exception {
		        // Call one method at a time to test

		        // testAdd();
		        //testUpdate();
		        //testDelete();
		        //testFindByPk();
		       //  testSearch();
		 }
	    public static void testAdd() throws Exception {
	        SubjectBean bean = new SubjectBean();
	        bean.setName("Computer Networks");
	        bean.setCourseId(101);
	        bean.setCourseName("B.Tech IT");
	        bean.setDescription("Introduction to networking concepts");
	        bean.setCreatedBy("admin");
	        bean.setModifiedBy("admin");

	        SubjectModel.add(bean);
	        System.out.println(" Subject added successfully!");
	    }

	    public static void testUpdate() throws Exception {
	        SubjectBean bean = new SubjectBean();
	        bean.setId(1); // Change this to existing subject ID
	        bean.setName("Advanced Networks");
	        bean.setCourseId(101);
	        bean.setCourseName("B.Tech IT");
	        bean.setDescription("Detailed networking study");
	        bean.setModifiedBy("faculty01");

	        SubjectModel.update(bean);
	        System.out.println(" Subject updated successfully!");
	    }

	    public static void testDelete() throws Exception {
	        int idToDelete = 2; // Change to existing subject ID
	        SubjectModel.delete(idToDelete);
	        System.out.println(" Subject deleted successfully!");
	    }

	    public static void testFindByPk() throws Exception {
	        int idToFind = 1; // Change to an existing ID
	        SubjectModel model = new SubjectModel();
	        SubjectBean bean = model.findByPk(idToFind);

	        if (bean != null) {
	            System.out.println(" Subject Found:");
	            System.out.println("ID: " + bean.getId());
	            System.out.println("Name: " + bean.getName());
	            System.out.println("Course Name: " + bean.getCourseName());
	        } else {
	            System.out.println(" Subject not found");
	        }
	    }

	    public static void testSearch() throws Exception {
	        SubjectBean bean = new SubjectBean();
	        bean.setName("Comp"); // Will search subjects starting with "Comp"
	        SubjectModel model = new SubjectModel();

	        List<SubjectBean> list = model.search(bean, 1, 10);

	        Iterator<SubjectBean> it = list.iterator();
	        while (it.hasNext()) {
	            SubjectBean s = it.next();
	            System.out.println("ID: " + s.getId());
	            System.out.println("Name: " + s.getName());
	            System.out.println("Course Name: " + s.getCourseName());
	            System.out.println("Description: " + s.getDescription());
	            System.out.println("------------------------------");
	        }
	    }

	   
	     
	    
	}


