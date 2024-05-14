package com.daoutilityvoters;

import java.sql.SQLException;

public interface DAOInterfaceVoters {
	boolean signIn(String email, String pass) throws SQLException;
}
