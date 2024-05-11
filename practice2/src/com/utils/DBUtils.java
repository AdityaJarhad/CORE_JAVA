package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection connection;
	private static final String DB_URL;
	private static final String USER_NAME;
	private static final String PASSWORD;
	static {
		DB_URL = "jdbc:mysql://localhost:3306/jdbc_data";
		USER_NAME = "root";
		PASSWORD = "Shiv@1234";
	}

	public static Connection openConnection() 
			throws /* ClassNotFoundException, */SQLException {
		// OPTIONAL : load JDBC driver
//		Class.forName("com.mysql.cj.jdbc.Driver");
		// get conneciton form DB : mandatory!
		connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		
		return connection;
	}
}
