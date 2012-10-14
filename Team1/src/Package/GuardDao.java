/**
 * 
 */
package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class GuardDao {
	
	public ArrayList<Guard> getGuards() throws Exception {
    ArrayList<Guard> rv = new ArrayList<Guard>();
    Class.forName("org.hsqldb.jdbcDriver");
    Connection conn = DriverManager.getConnection("jdbc:hsqldb:C:/hsql/BorderDB");
    Statement s = conn.createStatement();
    ResultSet rs = s.executeQuery("SELECT name, address, guards FROM guard");
    while(rs.next()) {
        Guard g = new Guard();
        g.setName(rs.getString(2));
        g.setAddress(rs.getString(3));
        g.setGuards(4);
        rv.add(g);
    }

    return rv;
}
}