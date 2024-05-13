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
	private PreparedStatement pst1;
	
	public DAOImplementation() throws SQLException{
		super();
		cn = openConnection();
		pst1 = cn.prepareStatement("select * from candidates");
	}

	public List<Candidate> displayCandidates() throws SQLException {
		List<Candidate> list = new ArrayList<>();
		ResultSet rs1 = pst1.executeQuery();
		while (rs1.next()) {
			 list.add(new Candidate(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getInt(4)));
		}
		return list;
	}
	
	public void clean() throws SQLException {
		if(pst1 != null)
			pst1.close();
	}
}
