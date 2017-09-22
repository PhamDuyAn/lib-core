package DAO;

import model.course;
import model.register;
import model.student;

import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import connect.cassandra;

public class registerDAO {
	private Session session;

	public void show() {
		cassandra con = new cassandra();
		con.connect("127.0.0.1", 9042);
		Session session = con.getSession();
		String sql = "SELECT * FROM register";
		for (Row row : session.execute(sql)) {
			System.out.println(row.toString());
		}
	}

	public void addRegister(register reg) {
		cassandra con = new cassandra();
		con.connect("127.0.0.1", 9042);
		Session session = con.getSession();
		String cql = "insert into register (idreg, studid, courseid,startcourse) values ("+ reg.getIdreg()+ ","+ reg.getStudid()+ ","+ reg.getCourseid() + ",'" + reg.getStartcourse() + "')";
		session.execute(cql);
	}

	public void showregister(int idreg) {
		cassandra con = new cassandra();
		con.connect("127.0.0.1", 9042);
		student st = new student();
		course co = new course();
		String startcourse = null, result1 = null, result2 = null;
		Session session = con.getSession();
		String sql = "Select * from register where idreg=" + idreg+ "";
		for (Row row : session.execute(sql)) {
			st.setStudid(row.getInt("studid"));
			co.setCourseid(row.getInt("courseid"));
			startcourse = row.getString("startcourse");
			try {
				String sql1 = "select * from student where studid="+ st.getStudid() + "";
				for (Row rows : session.execute(sql1)) {
					result1 = "student:" + rows.getInt("studid") + "...."+ rows.getString("fullname") + "...."+ rows.getString("phone") + "...."+ rows.getString("email");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			try {
				String sql2 = "select* from course where courseid="+ co.getCourseid() + "";
				for (Row row1 : session.execute(sql2)) {
					result2 = "course:" + row1.getInt("courseid") + "...."+ row1.getString("coursename") + " course time :"+ row1.getString("coursetime") ;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(result1 + result2 +" "+ "Start" + startcourse);
		}
	}
}