package BdeApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Jdbc{
	private static String host = "mysql-agp.alwaysdata.net";
	private static String base = "agp_data_mysql";
	private static String user = "agp_jdbc";
	private static String password = "jdbc223";
	private static String url = "jdbc:mysql://" + host + "/" + base;
	public static String affich = "";

	
	private ResultSet result;

	/**
	 * Lazy singleton instance.
	 */
	public static Connection connection;

	public Jdbc() {
		prepareConnection();

	}

	private void prepareConnection() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				System.err.println("Connection failed : " + e.getMessage());
			}
		}
	}

	
	public ResultSet execute(String query) throws SQLException {
		Statement state = connection.createStatement();
		ResultSet result = state.executeQuery(query);
		result.next();

		return result;
	}

	
	
	

}
