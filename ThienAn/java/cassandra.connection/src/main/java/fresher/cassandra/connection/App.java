package fresher.cassandra.connection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.datastax.driver.core.Row;

import model.course;
import model.register;
import DAO.courseDAO;
import DAO.registerDAO;

//import DAO.studentDAO;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

//		courseDAO co = new courseDAO();
//		 course cou = new course("4", "SPRING", "01-10-2017");
//		co.show();
//		 try {
//		 co.addCourse(cou);
//		 System.out.println("add thanh cong");
//		 } catch (Exception e) {
//		 System.out.print(e);
//		 }
//		 co.delete("1");
//		 System.out.println("da xoa");
		//course cou = new course("1", "JAVA WEB", "01-10-2018");
		//co.edit(cou);
		//System.out.println("update thanh cong");

//		List<course> as = co.Listcourse();
//		List<String> list = new ArrayList<String>();
//		for (course cru : as) {
//
//			list.add(cru.getCourseId());
//			
//
//		}
//		Collections.sort(list);
//		for (int i = 0; i < list.size(); i++) {
//			for (int j = 0; j < as.size(); j++) {
//				if (list.get(i).equals(as.get(j).getCourseId())) {
//					System.out.println(as.get(j).toString());
//					break;
//				}
//			}
//
//		}
		registerDAO re=new registerDAO();
		//registerDAO re=new registerDAO();
		re.showregister(1);

		// studentDAO st= new studentDAO();
		// st.show();

		// //Query
		// String query = "SELECT * FROM student";
		//
		// //Creating Cluster object
		// Cluster cluster =
		// Cluster.builder().addContactPoint("127.0.0.1").build();
		//
		// //Creating Session object
		// Session session = cluster.connect("demo");
		//
		// //Executing the query
		// for(Row row:session.execute(query)){
		// System.out.println(row.toString());
		// }
	}
}
