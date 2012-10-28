package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;

public class SetupDatabaseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		{
			Connection conn = null;
			try {
				Class.forName("org.hsqldb.jdbcDriver");
				 conn = DriverManager.getConnection(
						"C:/hsqldb/BorderDB", "annika", "annika");
				
				 printDbParams(conn, response);		

				DriverManager.println("Using database: "
						+ conn.getMetaData().getDatabaseProductName() + " "
						+ conn.getMetaData().getDatabaseProductVersion()
						+ " at " + conn.getMetaData().getURL());

				Statement s = conn.createStatement();
				s.execute("CREATE TABLE guard (id IDENTITY, name VARCHAR(50), age INT)");
				s.execute("INSERT INTO guard (name, age) VALUES ('Cooper', 25)");
				s.execute("INSERT INTO guard (name, age) VALUES ('Harry', 37)");
				s.execute("INSERT INTO guard (name, age) VALUES ('Johnny', 23)");
			} catch (Exception e) {
				DriverManager.println("Error: " + e.getMessage());

			}
			finally {
				closeDbConnection(conn);
				}
		}
	}

	private void closeDbConnection(Connection conn) {
		try {
		if(conn != null && !conn.isClosed()) {
		conn.close();
		}
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}
		}

		private void printDbParams(Connection conn, HttpServletResponse resp) throws IOException, SQLException {
		resp.setContentType("text/plain");

		ServletOutputStream out = resp.getOutputStream();
		out.println("Using database: " +
		conn.getMetaData().getDatabaseProductName() + " " +
		conn.getMetaData().getDatabaseProductVersion() + " at " +
		conn.getMetaData().getURL());
		}



		}