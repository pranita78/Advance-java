package in.co.rays.test;

		import in.co.rays.bean.CourseBean;
		import in.co.rays.model.CourseModel;

		import java.sql.Timestamp;
		import java.util.List;

		public class CourseTest {

		    public static void main(String[] args) throws Exception {
		        CourseTest test = new CourseTest
		        		
		        		();

		      //  test.testAdd();
		      //  test.testFindByPk();
		        //test.testUpdate();
		       // test.testSearch();
		       // test.testDelete();
		    }

		    public void testAdd() throws Exception {
		        CourseBean bean = new CourseBean();
		        bean.setName("B.Sc Mathematics");
		        bean.setDuration("3 Years");
		        bean.setDescription("Bachelor of Science in Mathematics");
		        bean.setCreatedBy("admin");
		        bean.setModifiedBy("admin");
		        bean.setCreatedDatetime(new Timestamp(System.currentTimeMillis()));
		        bean.setModifiedDatetime(new Timestamp(System.currentTimeMillis()));

		        CourseModel.add(bean);
		        System.out.println("Course Added Successfully");
		    }

		    public void testUpdate() throws Exception {
		        CourseModel model = new CourseModel();
		        CourseBean bean = model.findByPk(1); // Change ID as per your DB

		        if (bean != null) {
		            bean.setName("B.Sc Physics");
		            bean.setModifiedBy("admin_update");
		            bean.setModifiedDatetime(new Timestamp(System.currentTimeMillis()));
		            CourseModel.update(bean);
		            System.out.println(" Course Updated Successfully");
		        } else {
		            System.out.println("Course not found for update");
		        }
		    }

		    public void testDelete() throws Exception {
		        long idToDelete = 1; // Change this to an actual ID
		        CourseModel.delete(idToDelete);
		        System.out.println(" Course Deleted Successfully");
		    }

		    public void testFindByPk() throws Exception {
		        CourseModel model = new CourseModel();
		        CourseBean bean = model.findByPk(1); // Change ID as per your DB

		        if (bean != null) {
		            System.out.println("Course Found:");
		            System.out.println("ID: " + bean.getId());
		            System.out.println("Name: " + bean.getName());
		            System.out.println("Duration: " + bean.getDuration());
		            System.out.println("Description: " + bean.getDescription());
		        } else {
		            System.out.println("Course Not Found");
		        }
		    }

		    public void testSearch() throws Exception {
		        CourseModel model = new CourseModel();
		        CourseBean searchBean = new CourseBean();
		        searchBean.setName("B.Sc");

		        List<CourseBean> list = model.search(searchBean, 1, 10);
		        System.out.println("Search Results:");
		        for (CourseBean bean : list) {
		            System.out.println("ID: " + bean.getId() + " | Name: " + bean.getName() + " | Duration: " + bean.getDuration());
		        }
		    }
		}