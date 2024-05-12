package com.daointerface;

import java.sql.SQLException;
import java.util.List;

import com.app.entities.User;

public interface DAOInterface {
	//display all users
	List<User> displyDetails() throws SQLException;
	// sign in
	User signIn(String next, String next2) throws SQLException;
	//update passwd
	String updatePasswd(String email, String oldPasswd, String newPasswd) throws SQLException;
	//delete user
	public String deleteVoter(String email, String passwd) throws SQLException;
	// add user
	String addUser(User user) throws SQLException;
}
