package com.app.tester;

import java.sql.*;
import static com.app.utils.DBUtils.openConnection;

public class TestStatement {

	public static void main(String[] args) {
		try (// get databse connection
				Connection cn = openConnection();
				// create empty statement, to hold the sql
				Statement st = cn.createStatement();
				// wxwcute sqlQuery n ger ResultSet
				ResultSet rst = st.executeQuery("select * from users order by email");) {
			// ResultSet processing
			// cursor --> before the 1st row
			while(rst.next()) {
				/*
				 * | id | first_name | last_name | email | password | dob | status | role
				 */
				System.out.printf("Id %d Name %s %s Email %s "
						+"Passwd %s DOB %s Stutus %b Role %s %n",
						rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getDate(6), rst.getBoolean(7), rst.getString(8));
			}
			
		} // JVM : rst.close(), st.close() cn.close() => cleaning up of DB resources
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
