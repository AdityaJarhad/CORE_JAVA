package com.daoutility;

import static com.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.core.Candidate;

public class DAOImplementation implements DAOInterface {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3, pst4;

	public DAOImplementation() throws SQLException {
		super();
		cn = openConnection();
		pst1 = cn.prepareStatement("select * from candidates");
		// please vote
		pst2 = cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		// winner
		pst3 = cn.prepareStatement("select * from candidates order by votes desc limit 2");
		//party name and votes
		pst4 = cn.prepareStatement("select party, sum(votes) from candidates group by party");
	}

	public List<Candidate> displayCandidates() throws SQLException {
		List<Candidate> list = new ArrayList<>();
		ResultSet rs1 = pst1.executeQuery();
		while (rs1.next()) {
			list.add(new Candidate(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getInt(4)));
		}
		return list;
	}

	@Override
	public String pleaseVote(int vote) throws SQLException {
		pst2.setInt(1, vote);
		int v = pst2.executeUpdate();
		if (v == 1)
			return "Successful vote";
		throw new SQLException("Invalid vote");
	}



	public List<Candidate> twoWinner() throws SQLException {
		List<Candidate> list1 = new ArrayList<>();
		try (ResultSet rs3 = pst3.executeQuery();) {
			while (rs3.next()) {
				list1.add(new Candidate(rs3.getInt(1), rs3.getString(2), rs3.getString(3), rs3.getInt(4)));
			}
			return list1;
		}

	}
	
	public List<Candidate> partyNvotes() throws SQLException {
		List<Candidate> list2 = new ArrayList<>();
		ResultSet rs4 = pst4.executeQuery();
		while (rs4.next()) {
			list2.add(new Candidate(rs4.getString(1), rs4.getInt(2)));			
		}
		return list2;
	}
	
	public void clean() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
	}

}
