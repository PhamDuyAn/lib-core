import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ConnectionMySQL.ConnectionMySQL;



public class Main {
	//private static final Log log = LogFactory.getLog(Main.class);
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Students st=new Students();
		// TODO Auto-generated method stub
		//Course cor=new Course();
		//cor.ShowCourse();
		//st.ShowStudent();
		//st.AddStudent(2,"an","ha Noi","1996-02-01",1);
		//st.Deletetudent(2);
		//st.EditStudent(2,"PhamDuy An","ND","1995-01-1");
		Proccessing pro=new Proccessing();
		pro.ShowStudentIntoCourse(1);
		pro.AddStudentIntoCourse(2, 3);
		//pro.EditStudentIntoCourse(1, idcourse);
		pro.DeleteStudentIntoCourse(1, 2);
	}

}
