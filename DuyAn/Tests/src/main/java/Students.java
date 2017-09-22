import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.jar.Attributes.Name;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ConnectionMySQL.ConnectionMySQL;

public class Students {
	ResultSet rs;
	private static final Log log = LogFactory.getLog(Course.class);
	private int IDStudent;
	private String NameStudent,Address,DateStudent,Sex;
	public int getIDStudent() {
		return IDStudent;
	}
	public void setIDStudent(int iDStudent) {
		IDStudent = iDStudent;
	}
	public String getNameStudent() {
		return NameStudent;
	}
	public void setNameStudent(String nameStudent) {
		NameStudent = nameStudent;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDateStudent() {
		return DateStudent;
	}
	public void setDateStudent(String dateStudent) {
		DateStudent = dateStudent;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public Students()
	{
		IDStudent=0;
		NameStudent="";
		DateStudent="1990-1-1";
		Sex="";
		Address="";
	}
	public Students(int IDStudent, String NameStudent,String Address,String Date,String Sex)
	{
		this.IDStudent=IDStudent;
		this.NameStudent=NameStudent;
		this.Address=Address;
		this.DateStudent=Date;
		this.Sex=Sex;
		
	}
	public void GetStudent()
	{
		log.info("ID Student: "+IDStudent);
		log.info("Name Student: "+NameStudent);
		log.info("Date of birth: "+DateStudent);
		log.info("Date of birth: "+Sex);
		log.info("Address Student: "+Address);
	}
	public void ShowStudent() throws ClassNotFoundException, SQLException
	{
		Connection connection = ConnectionMySQL.getMySQLConnection();

	       Statement statement = connection.createStatement();
	  
	       String sql = "Select idStudents, NameStudents,DateStudents,Sex,AddressStudents from students";
	  

	       rs = statement.executeQuery(sql);
	       while (rs.next())
	       {
	    	   log.info("ID student: "+rs.getInt(1)+" --- Name Student: "+rs.getString(2)+" --- Date of birth Student: "+rs.getString(3)+" --- Sex Student: "+rs.getString(4)+" --- Address Student: "+rs.getString(5));
	    	 //  log.info(rs.getString(2));
	       }
	}
	public void AddStudent(int id,String name,String date,String Sex,String address) throws ClassNotFoundException, SQLException
	{
		Connection connection = ConnectionMySQL.getMySQLConnection();

	       Statement statement = connection.createStatement();
	  
	       String sql = "INSERT INTO `courseandstudent`.`students` (`idStudents`, `NameStudents`, `DateStudents`, `Sex`, `AddressStudents`) VALUES ('"+id+"', '"+name+"', '"+date+"', '"+Sex+"', '"+address+"');";
	      try {
	        int update = statement.executeUpdate(sql);
	        if(update>=1)
	        {
	        	log.info("Add succesfull");
	        }
	       
	       
	      }
	      catch(Exception ex)
	      {
	    	  String mess=ex.getMessage();
	    	  log.error("Erro: Add_________");
	    	  log.error(mess);
	      }
	}
	public void EditStudent(int id,String name,String address,String date,String sex) throws ClassNotFoundException, SQLException
	{
		Connection connection = ConnectionMySQL.getMySQLConnection();

	       Statement statement = connection.createStatement();
	  
	       String sql = "UPDATE `courseandstudent`.`students` SET `NameStudents`='"+name+"', `DateStudents`='"+date+"', `Sex`='"+sex+"', `AddressStudents`='Ha Noii' WHERE `idStudents`='"+id+"';";
	      try {
	         statement.executeUpdate(sql);
	        
	         log.info("Edit succesfull");
	      }
	      catch(Exception ex)
	      {
	    	  String mess=ex.getMessage();
	    	  log.error("Edit erro.");
	    	  log.error(mess);
	      }
	}
	public void Deletetudent(int id) throws ClassNotFoundException, SQLException
	{
		Connection connection = ConnectionMySQL.getMySQLConnection();

	       Statement statement = connection.createStatement();
	  
	       String sql = "Delete from courseandstudent.students WHERE idStudents="+id+";";
	      try {
	         statement.executeUpdate(sql);
	        
	         log.info("Delete succesfull");
	      }
	      catch(Exception ex)
	      {
	    	  String mess=ex.getMessage();
	    	  log.error("Delete erro.");
	    	  log.error(mess);
	      }
	}
}
