package com.daoutility;

import java.sql.SQLException;
import java.util.List;

import com.app.core.Candidate;

public interface DAOInterface {
	List<Candidate> displayCandidates() throws SQLException ;
	
	String pleaseVote(int vote) throws SQLException;
	
	List<Candidate> twoWinner() throws SQLException;
	
	List<Candidate> partyNvotes() throws SQLException;
}
