package com.daoutilityvoters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.utils.DBUtils.openConnection;;

public class DAOImplVoters implements DAOInterfaceVoters {
	private Connection cn;
	private PreparedStatement pst1;
	
	public DAOImplVoters() throws SQLException {
		super();
		cn = openConnection();
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
	}

	public boolean signIn(String email, String pass) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, pass);
		ResultSet rs = pst1.executeQuery();
		if(rs.next())
			return true;
		throw new SQLException("User not exists");
		
	}

	
	
	
	
}
 