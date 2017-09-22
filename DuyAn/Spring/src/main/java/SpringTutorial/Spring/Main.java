package SpringTutorial.Spring;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Spring.tutorial.DAO.StudentDAO;
import Spring.tutorial.jdbcTemplate.StudenJDBCTemplate;
import Spring.tutorial.obj.StudentObj;

public class Main {
	@SuppressWarnings("resource")
	private static final Log log = LogFactory.getLog(StudentDAO.class);
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//		try {
//			StudenJDBCTemplate studentJDBCTemplate = (StudenJDBCTemplate) context.getBean("studentJDBCTemplate");
//
//			String date = "2000-1-1";
//			DateFormat datebirth = new SimpleDateFormat("yyyy-MM-dd");
//			studentJDBCTemplate.createStudent(7, "Khoa", datebirth.parse(date), "gay", "HN");//insert
//			log.info("Add cussessful");
//			
//		} catch (Exception e) {
//			String mes = e.getMessage();
//			log.info(mes);
//		}
		try {
			ArrayList<StudentObj> stu=new ArrayList<StudentObj>();//list ra danh sach mang 
			StudenJDBCTemplate studentJDBCTemplate = (StudenJDBCTemplate) context.getBean("studentJDBCTemplate");//id  bean
			//stu = studentJDBCTemplate.getStudent(4);
			stu = (ArrayList<StudentObj>) studentJDBCTemplate.listStudents();
			log.info("Id    ------ :  "+stu.toString());
		} catch (Exception e) {
			String mes = e.getMessage();
			log.error(mes);
		}
		try {
			StudentObj stu=new StudentObj();//lay theo id 
			StudenJDBCTemplate studentJDBCTemplate = (StudenJDBCTemplate) context.getBean("studentJDBCTemplate");//id  bean
			//stu = studentJDBCTemplate.getStudent(4);
			stu = studentJDBCTemplate.getStudent(2);
			log.info("Id    ------ :  "+stu.toString());
		} catch (Exception e) {
			String mes = e.getMessage();
			log.error(mes);
		}

	}
}
