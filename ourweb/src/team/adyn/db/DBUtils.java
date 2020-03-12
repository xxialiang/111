package team.adyn.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {

	private static Connection conn = null;
	private static final String className = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/training";
	private static final String user = "root";
	private static final String password = "92658";

	public static Connection getconn() {
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}

	public static void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
