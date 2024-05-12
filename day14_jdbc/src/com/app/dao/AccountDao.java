package com.app.dao;

import java.sql.SQLException;

public interface AccountDao {
//	Add a method for invoking a stored proc from DB, to transfer funds
	String tranferFunds (int srcAcNo, int destAcNo, double amount) throws SQLException;
	
	
	
}
