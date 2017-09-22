import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.jar.Attributes.Name;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ConnectionMySQL.ConnectionMySQL;


public class Proccessing {
	private static final Log log = LogFactory.getLog(Proccessing.class);
	public static void ShowStudentIntoCourse(int id) throws ClassNotFoundException, SQLException
	{
		Connection connection = ConnectionMySQL.getMySQLConnection();

	       Statement statement = connection.createStatement();
	  
	       String sql = "Select std.idStudents, std.NameStudents,std.Sex,cor.NameCourse,cor.StartDay,cor.EndDay from course cor,students std,connect cn where std.idStudents='"+id+"' and cn.idStudent=std.idStudents and cor.idCourse=cn.idCourse;";

	       ResultSet rs = statement.executeQuery(sql);
	       while (rs.next())
	       {
	    	   log.info("ID Student: "+rs.getInt(1)+"-----"+rs.getString(2)+"------"+rs.getString(3)+"-----"+rs.getString(4)+"-----"+rs.getString(5)+"-----"+rs.getString(6));
	    	
	       }
	}

	public static void AddStudentIntoCourse(int idstudent,int idcourse) throws ClassNotFoundException, SQLException
	{
		Connection connection = ConnectionMySQL.getMySQLConnection();

	       Statement statement = connection.createStatement();
	  
	       String sql = "INSERT INTO `courseandstudent`.`connect` (`idCourse`, `idStudent`) VALUES ('"+idstudent+"', '"+idcourse+"');";
	      try {
	        int update = statement.executeUpdate(sql);
	        if(update>=1)
	        {
	        	log.info("succesfull");
	        }
	       
	       
	      }
	      catch(Exception ex)
	      {
	    	  String mess=ex.getMessage();
	    	  log.error("Erro: Add_________");
	    	  log.error(mess);
	      }
	}
	public static void EditStudentIntoCourse(int idstudent, int idcourse) throws ClassNotFoundException, SQLException
	{
		Connection connection = ConnectionMySQL.getMySQLConnection();

	       Statement statement = connection.createStatement();
	  
	       String sql = "UPDATE `courseandstudent`.`connect` SET `idCourse`='"+idcourse+"' WHERE `idStudent`='"+idstudent+"';";
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
	public static void DeleteStudentIntoCourse(int idstudent,int idcourse) throws ClassNotFoundException, SQLException
	{
		Connection connection = ConnectionMySQL.getMySQLConnection();

	       Statement statement = connection.createStatement();
	  
	       String sql = "Delete from connect WHERE idStudent="+idstudent+" and idCourse="+idcourse+";";
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
