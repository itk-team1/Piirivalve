package Servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SetupDatabaseServlet {
	
	{

		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection conn = DriverManager.getConnection("C:/hsql/BorderDB",
					"annika", "annika");

			DriverManager.println("Using database: "
					+ conn.getMetaData().getDatabaseProductName() + " "
					+ conn.getMetaData().getDatabaseProductVersion() + " at "
					+ conn.getMetaData().getURL());

			Statement s = conn.createStatement();
			s.execute("CREATE TABLE guards (id int, nimi char(50), aadress char(50), guards tinyint(5)); commit;");

		} catch (Exception e) {
			DriverManager.println("Error: " + e.getMessage());

		}
	}
}
