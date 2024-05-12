package com.daointerface;

import static com.utils.DBUtils.closeConnection;
import static com.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.entities.User;

public class DAOImpl implements DAOInterface {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3, pst4, pst5;

	public DAOImpl() throws SQLException {
		// establish connection
		cn = openConnection();
		// display voters
		pst1 = cn.prepareStatement("select * from users");
		// sign in
		pst2 = cn.prepareStatement("select * from users where email=? and password=?");
		// update password
//		 id | first_name | last_name | email| password | dob | status | role
		pst3 = cn.prepareStatement("update users set password=? where email=? and password=?");
		// remove voter
		pst4 = cn.prepareStatement("delete from users where email=? and password=?");
		//Add user
		pst5 = cn.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");

	}

	@Override
	public List<User> displyDetails() throws SQLException {
		List<User> list = new ArrayList<>();
		ResultSet rs1 = pst1.executeQuery();
		while (rs1.next()) {
			list.add(new User(rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getDate(6),
					rs1.getBoolean(7), rs1.getString(8)));
		}

		return list;
	}

	@Override
	public User signIn(String email, String passwd) throws SQLException {
		pst2.setString(1, email);
		pst2.setString(2, passwd);
		User user;
		ResultSet rs2 = pst2.executeQuery();
		if (rs2.next()) {
			user = new User(rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getString(5), rs2.getDate(6),
					rs2.getBoolean(7), rs2.getString(8));
			return user;
		}
		throw new SQLException("Invalid credentials");
	}

	public String updatePasswd(String email, String oldPasswd, String newPasswd) throws SQLException {
		pst3.setString(1, newPasswd);
		pst3.setString(2, email);
		pst3.setString(3, oldPasswd);
		int rows = pst2.executeUpdate();
		if (rows == 1) {
			return "updated";
		}

		return "Password not updated";
	}

	public String deleteVoter(String email, String passwd) throws SQLException{
		pst4.setString(1, email);
		pst4.setString(2, passwd);

		int rs3 = pst4.executeUpdate();
		if(rs3 == 1)
		{
			return "Deleted";
		}
		
		throw new SQLException("User not found");
	}

	public String addUser(User user) throws SQLException {
//		 id | first_name | last_name | email| password | dob | status | role

		pst5.setString(1, user.getFirstName());
		pst5.setString(2, user.getLastName());
		pst5.setString(3, user.getEmail());
		pst5.setString(4, user.getPassword());
		pst5.setDate(5,user.getDob());
		pst5.setBoolean(6, user.isStatus());
		pst5.setString(7, user.getRole());
		
		int row = pst5.executeUpdate();
		if(row == 1)
			return "Registration successful!";
		return "Registration failed";
	}

	public void close() throws SQLException {
		System.out.println("User DAO cleaned up");
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (pst4 != null)
			pst4.close();
		if (pst5 != null)
			pst5.close();

		closeConnection();
	}


}
