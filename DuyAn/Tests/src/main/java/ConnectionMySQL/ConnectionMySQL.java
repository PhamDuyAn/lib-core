package ConnectionMySQL;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
 

 
public class ConnectionMySQL {
	private static final Log log = LogFactory.getLog(ConnectionMySQL.class);
	public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException
	{
		String hostName = "localhost";
		String dbName = "courseandstudent";
		String userName = "root";
		String password = "1234";
		
		return getMySQLConnection(hostName, dbName, userName, password);
	}
	
	public static Connection getMySQLConnection(String hostName, String dbName,String userName, String password) throws SQLException,ClassNotFoundException 
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		try
		{
		Connection conn = DriverManager.getConnection(connectionURL, userName,
		        password);
		log.info("INFO: Ket noi thanh cong.");

		return conn;
				}
		catch(SQLException e)
		{
			String mes= e.getMessage();
			log.error("ERRO: Koi ket noi.");
			log.error("ERRO: "+mes);
		}
		return null;
	}
}
