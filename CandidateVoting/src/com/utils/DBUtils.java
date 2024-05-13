package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection connection;
	private static final String DB_URL;
	private static final String DB_NAME;
	private static final String DB_PASSWD;
	
	static {
		DB_URL = "jdbc:mysql://localhost:3306/jdbc_data";
		DB_NAME = "root";
		DB_PASSWD = "Shiv@1234";
	}
	
	public static Connection openConnection() throws SQLException
	{
		connection = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWD);
		
		return connection;
	}
	
	public static void closeConnection() throws SQLException
	{
		if(connection != null)
			connection.close();

		System.out.println("DB connection closed");
	}
	
	
	
	
	
	
}
