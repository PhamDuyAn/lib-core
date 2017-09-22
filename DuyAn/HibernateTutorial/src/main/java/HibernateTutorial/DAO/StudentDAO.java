package HibernateTutorial.DAO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import HibernateTutorial.HibernateTutorial.Course;
import HibernateTutorial.HibernateTutorial.Date;
import HibernateTutorial.HibernateTutorial.HibernateUtil;
import HibernateTutorial.HibernateTutorial.Student;

public class StudentDAO {
	private static final Log log = LogFactory.getLog(StudentDAO.class);

	public void AddStudents(int id, String Name, String Date, String Sex, String Address) throws ParseException {

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.getCurrentSession();
		Student student = new Student();

		try {
			DateFormat datebirth = new SimpleDateFormat("yyyy-MM-dd");// dinh dang ngay cho chuoi

			session.getTransaction().begin();
			student.setIdStudents(id);					// đối tượng cor Transient.
			student.setNametudents(Name);
			student.setDateStudents(datebirth.parse(Date));
			student.setSex(Sex);
			student.setAddressStudents(Address);
			
			
			session.save(student);// trang thai persist
			// session.save(student);
			session.getTransaction().commit();

			log.info("Add student succesfull------------------------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			log.info("Add student erro--------------------------------------------------------------------");
		}

		// Sau khi session bị đóng lại (commit, rollback, close)
		// Đối tượng 'emp', 'dept' trở thành đối tượng Detached.
		// Nó không còn trong sự quản lý của session nữa.

		// System.out.println("Emp No: " + course.getEmpNo());
	}

	public void getStudents() {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.getTransaction().begin();

			String sql = "Select student from " + Student.class.getName() + " student";

			Query<Student> query = session.createQuery(sql);// Tạo đối tượng Query.

			List<Student> student = query.getResultList();// Thực hiện truy vấn lấy ra dữ liệu.

			for (Student std : student) {
				log.info("Student: " + std.getIdStudents() + " ----- " + std.getNametudents() + "--- Date: "
						+ std.getDateStudents() + "--- Sex: " + std.getSex()+"----Address: "+std.getAddressStudents());
			}

			session.getTransaction().commit();// Commit dữ liệu

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();// Rollback trong trường hợp có lỗi xẩy ra.
			log.error("erro getstudent-------------------------------------------------");
		}
	}

	public void EditStudents(int id,String Name,String Date,String Sex,String Address) {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.getCurrentSession();
		Student student = new Student();

		try {
			//String date = "1999-10-10";
			DateFormat datebirth = new SimpleDateFormat("yyyy-MM-dd");// dinh dang ngay cho chuoi
			session.getTransaction().begin();
			student.setIdStudents(id);
			student.setNametudents(Name);
			student.setDateStudents(datebirth.parse(Date));// ep kieu ngay
			student.setSex(Sex);
			student.setAddressStudents(Address);
			session.update(student);// trang thai persist
			// session.save(cor);	//có thể dùng save
			session.getTransaction().commit();

			log.info("Edit student succesfull---------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			log.info("Edit student erro--------------------------------------------------------");
		}
	}

	public void DelStudents(int id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();
			session.delete(session.find(Student.class, id));// delêt obj student theo id
			session.getTransaction().commit();
			log.info("Delete student succesfull---------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			log.info("Delete student erro--------------------------------------------------------");
		}

	}

}
