package com.app.tester;

import static com.app.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestPrepareStatement {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				// get databse connection
				Connection cn = openConnection();
				// create pre- compiled statement, to hold the sql
				PreparedStatement pst = cn.prepareStatement("select * from users where email=? and password=?")) {
			System.out.println("Enter email and passwd");
			// set IN params : public void setType(int paramIns=dex, Type value
			pst.setString(1, sc.next()); // email
			pst.setString(2, sc.next()); // passwd
			// exec query
			try (ResultSet rst = pst.executeQuery()) {
				if(rst.next())
					System.out.println("Login successfull! Hello, "+rst.getString(2)+" "+rst.getString(3));
				else
					System.out.println("Login failed...");
			}

		} // JVM : rst.close(), st.close() cn.close() => cleaning up of DB resources
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
