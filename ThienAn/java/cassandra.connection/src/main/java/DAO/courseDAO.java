package DAO;
import java.util.ArrayList;
import java.util.List;

import model.course;

import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import connect.cassandra;
public class courseDAO {
	private cassandra con;
	private Session session;
	public void show(){
    con=new cassandra();
	con.connect("127.0.0.1", 9042);
	session=con.getSession();
	String sql= "SELECT * FROM course";
	for(Row row:session.execute(sql)){
    	System.out.println(row.toString());
      }
	}
	 public void addCourse(course courseId){
	
	 String cql = "insert into course (courseId, courseName, courseTime) values ("+courseId.getCourseid()+",'"+ courseId.getCourseName()+"','"+courseId.getCourseTime()+"')";
	 session.execute(cql);
	   
			        
	 }
	 public void delete(int courseId){
		 con=new cassandra();
			con.connect("127.0.0.1", 9042);
			session=con.getSession();	 
		String cql= "delete from course where courseid="+courseId+";";
		 session.execute(cql);
	 }
	 public void edit(course courseid){
		 
		    con=new cassandra();
			con.connect("127.0.0.1", 9042);
			session=con.getSession();	
			 String cql = "UPDATE demo.course SET courseName='"+courseid.getCourseName()+"', courseTime='"+courseid.getCourseTime()+"' WHERE courseid="+courseid.getCourseid()+";";
			 session.execute(cql);
	 }
	 public List<course> Listcourse(){
		String cql="SELECT * FROM course";
		List<course> course= new ArrayList<course>();
		
		
		for(Row row:session.execute(cql)){
			course cour=new course();	
			cour.setCourseid(row.getInt("courseid"));
			cour.setCourseName(row.getString("coursename"));
			cour.setCourseTime(row.getString("coursetime"));
			course.add(cour);
		}
		
		
		return course;
	 }
	 
}
