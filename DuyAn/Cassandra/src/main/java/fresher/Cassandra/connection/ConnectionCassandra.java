package fresher.Cassandra.connection;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

//import Main.CassandraConnector;

public class ConnectionCassandra {
	private Cluster cluster;
	 
    private Session session;
 
    public void connect(String node, Integer port) {
        com.datastax.driver.core.Cluster.Builder b = Cluster.builder().addContactPoint(node);
        if (port != null) {
            b.withPort(port);
        }
        cluster = b.build();
 
        session = cluster.connect("duyan");
    }
 
    public Session getSession() {
        return this.session;
    }
 
    public void close() {
        session.close();
        cluster.close();
    }
	
}

