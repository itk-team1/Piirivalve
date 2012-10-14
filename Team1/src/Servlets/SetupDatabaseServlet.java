package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;

public class SetupDatabaseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		{

			try {
				Class.forName("org.hsqldb.jdbcDriver");
				Connection conn = DriverManager.getConnection(
						"C:/hsql/BorderDB", "annika", "annika");

				DriverManager.println("Using database: "
						+ conn.getMetaData().getDatabaseProductName() + " "
						+ conn.getMetaData().getDatabaseProductVersion()
						+ " at " + conn.getMetaData().getURL());

				Statement s = conn.createStatement();
				s.execute("CREATE TABLE guards (id int, nimi char(50), aadress char(50), guards tinyint(5)); commit;");

			} catch (Exception e) {
				DriverManager.println("Error: " + e.getMessage());

			}
		}
	}
}
