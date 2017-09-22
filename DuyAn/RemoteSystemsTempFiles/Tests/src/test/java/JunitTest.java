import java.sql.SQLException;

import ConnectionMySQL.ConnectionMySQL;
import junit.framework.TestCase;

public class JunitTest extends TestCase{
	public static void testconnection() {
		try {
			assertTrue(ConnectionMySQL.getMySQLConnection()!=null);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
//		testconnection();
		// TODO Auto-generated method stub
		junit.textui.TestRunner.run(JunitTest.class);//test cac class test

	}

}
