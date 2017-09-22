package DAO;

import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import connect.cassandra;

public class studentDAO {
	public void show(){
		cassandra con=new cassandra();
		con.connect("127.0.0.1", 9042);
		Session session=con.getSession();
		String sql= "SELECT * FROM student";
		for(Row row:session.execute(sql)){
	    	System.out.println(row.toString());
	      } 
	}
}
