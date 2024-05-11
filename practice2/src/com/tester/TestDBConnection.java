package com.tester;
import static com.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDBConnection {
	public static void main(String[] args) {
		try(Connection connection = openConnection())
		{
			System.out.println("Connection establish "+connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
