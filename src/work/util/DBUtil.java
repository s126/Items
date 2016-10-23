package work.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {

	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	static {
		try {

			Properties prop = new Properties();
			prop.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");

			Class.forName(driver);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// create the connection
	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	// close all resources
	public static void closeAll(ResultSet rs, Statement ps, Connection conn) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
