import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ConnectionMySQL.ConnectionMySQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import ConnectionMySQL.ConnectionMySQL;

public class Course {

	private static final Log log = LogFactory.getLog(Course.class);
	private int IDCourse,Numbers;
	public int getIDCourse() {
		return IDCourse;
	}

	public void setIDCourse(int iDCourse) {
		IDCourse = iDCourse;
	}

	public int getNumbers() {
		return Numbers;
	}

	public void setNumbers(int numbers) {
		Numbers = numbers;
	}

	public String getNameCourse() {
		return NameCourse;
	}

	public void setNameCourse(String nameCourse) {
		NameCourse = nameCourse;
	}

	public String getStartDay() {
		return StartDay;
	}

	public void setStartDay(String startDay) {
		StartDay = startDay;
	}

	public String getEndDay() {
		return EndDay;
	}

	public void setEndDay(String endDay) {
		EndDay = endDay;
	}
	private String NameCourse,StartDay,EndDay;
	
	public Course(int IDCourse, String NameCourse,String StartDay,String EndDay,int Numbers)
	
	{
		this.IDCourse=IDCourse;
		this.NameCourse=NameCourse;
		this.StartDay=StartDay;
		this.EndDay = EndDay;
		this.Numbers = Numbers;
	}
	
	public Course()
	{
		IDCourse=0;
		NameCourse="Duy An";
		StartDay="1999-10-10";
		EndDay="1999-10-10";
		Numbers=0;
	}
	
	public void SetID(int IDCourse)
	{
		this.IDCourse=IDCourse;
	}
	
	public void GetCourse()
	{
		log.info("ID Course: "+IDCourse);
		log.info("Name Course: "+NameCourse);
	}
	public void ShowCourse() throws ClassNotFoundException, SQLException
	{
		Connection connection = ConnectionMySQL.getMySQLConnection();

	       Statement statement = connection.createStatement();
	  
	       String sql = "Select * from course";

	       ResultSet rs = statement.executeQuery(sql);
	       while (rs.next())
	       {
	    	   log.info("ID: "+rs.getInt(1)+"--- Name Course: "+rs.getString(2)+"---Start Day: "+rs.getString(3)+" --- End Day: "+rs.getString(4)+" --- Number: "+rs.getString(5));
	    	 //  log.info(rs.getString(2));
	       }
	}
	
	
	public void AddCourse(int id,String name,String start,String end,int numbers) throws ClassNotFoundException, SQLException
	{
		Connection connection = ConnectionMySQL.getMySQLConnection();

	       Statement statement = connection.createStatement();
	  
	       String sql = "INSERT INTO `courseandstudent`.`course` (`idCourse`, `NameCourse`, `StartDay`, `EndDay`, `Numbers`) VALUES ('"+id+"', '"+name+"', '"+start+"', '"+end+"', '"+numbers+"');";
	      try {
	        int update = statement.executeUpdate(sql);
	        if(update>=1)
	        {
	        	log.info("Add course succesfull");
	        }
	       
	       
	      }
	      catch(Exception ex)
	      {
	    	  String mess=ex.getMessage();
	    	  log.error("Erro: Add__course___");
	    	  log.error(mess);
	      }
	}
	
	public void EditCourse(int id,String name,String start,String end,String numbers) throws ClassNotFoundException, SQLException
	{
		Connection connection = ConnectionMySQL.getMySQLConnection();

	       Statement statement = connection.createStatement();
	  
	       String sql = "UPDATE `courseandstudent`.`course` SET `NameCourse`='"+name+"', `StartDay`='"+start+"', `EndDay`='"+end+"', `Numbers`='"+numbers+"' WHERE `idCourse`='"+id+"';";
	      try {
	         statement.executeUpdate(sql);
	        
	         log.info("Edit course succesfull");
	      }
	      catch(Exception ex)
	      {
	    	  String mess=ex.getMessage();
	    	  log.error("Edit course erro.");
	    	  log.error(mess);
	      }
	}
	public void DeleteCourse(int id) throws ClassNotFoundException, SQLException
	{
		Connection connection = ConnectionMySQL.getMySQLConnection();

	       Statement statement = connection.createStatement();
	  
	       String sql = "DELETE FROM `courseandstudent`.`course` WHERE `idCourse`='"+id+"';";
	      try {
	         statement.executeUpdate(sql);
	        
	         log.info("Delete course succesfull");
	      }
	      catch(Exception ex)
	      {
	    	  String mess=ex.getMessage();
	    	  log.error("Delete course erro.");
	    	  log.error(mess);
	      }
	}
}
