package HibernateTutorial.DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import HibernateTutorial.HibernateTutorial.Course;
import HibernateTutorial.HibernateTutorial.HibernateUtil;

public class CourseDAO {
	private static final Log log = LogFactory.getLog(Course.class);

	public void getCourse() {

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.getTransaction().begin();

			String sql = "Select cor from " + Course.class.getName() + " cor";

			// Tạo đối tượng Query.
			Query<Course> query = session.createQuery(sql);

			// Thực hiện truy vấn.
			List<Course> course = query.getResultList();

			for (Course cor : course) {
				log.info("Course: " + cor.getIdCourse() + " ----- " + cor.getNameCourse() + "--- Start: "
						+ cor.getStartDay() + "--- End" + cor.getEndDay() + "--- Numbers: " + cor.getNumbers());
			}

			session.getTransaction().commit();// Commit dữ liệu

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback trong trường hợp có lỗi xẩy ra.
			session.getTransaction().rollback();
		}
	}

	public void AddCourse() {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.getCurrentSession();
		Course cor = new Course();

		try {
			session.getTransaction().begin();
			// đối tượng cor Transient.
			cor.setIdCourse(8);
			// session.persist(cor.getIdCourse());
			cor.setNameCourse("Python");
			cor.setStartDay("2017-9-9");
			cor.setEndDay("2017-9-9");
			cor.setNumbers(23);

			session.persist(cor);// trang thai persist
			// session.save(cor);
			session.getTransaction().commit();

			log.info("Add course succesfull");

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			log.info("Add course erro");
		}

		// Sau khi session bị đóng lại (commit, rollback, close)
		// Đối tượng 'emp', 'dept' trở thành đối tượng Detached.
		// Nó không còn trong sự quản lý của session nữa.

		// System.out.println("Emp No: " + course.getEmpNo());
	}

	public void EditCourse(int id) {

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.getCurrentSession();
		Course cor = new Course();

		try {
			session.getTransaction().begin();
			// đối tượng cor Transient.
			cor.setIdCourse(id);
			// session.persist(cor.getIdCourse());
			cor.setNameCourse("Python");
			cor.setStartDay("2017-9-9");
			cor.setEndDay("2017-10-8");
			cor.setNumbers(20);

			session.update(cor);// trang thai persist
			// session.save(cor);
			session.getTransaction().commit();

			log.info("Edit course succesfull");

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			log.info("Edit course erro");
		}
	}

	public void DelCourse(int id) {

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();
			session.delete(session.find(Course.class, id));// delêt obj course theo id
			session.getTransaction().commit();
			log.info("Delete course succesfull");

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			log.info("Delete course erro");
		}
	}
}
