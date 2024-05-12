package com.app.dao;

import static com.app.utils.DBUtils.closeConnection;
import static com.app.utils.DBUtils.openConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class AcntDaoImpl implements AccountDao{

	private Connection cn;
	private CallableStatement cst1;
	
	//def. cnstr
	public AcntDaoImpl() throws SQLException{
		
		cn = openConnection();
		
		cst1 = cn.prepareCall("{call transfer_funds_proc(?,?,?,?,?)}");
		
		cst1.registerOutParameter(4, Types.DOUBLE);
		cst1.registerOutParameter(5, Types.DOUBLE);
		System.out.println("Acnt Dao created");
	}
		
	@Override
	public String tranferFunds(int srcAcNo, int destAcNo, double amount) throws SQLException {
		// 1. Set in params
		cst1.setInt(1, srcAcNo);
		cst1.setInt(2, destAcNo);
		cst1.setDouble(3, amount);
		//2. execute the proc
		cst1.execute();
		return "Updated src balance "+ cst1.getDouble(4)+" dest balance "+ cst1.getDouble(5);
	}
	
//	clean up
	public void cleanUp() throws SQLException
	{
		if(cst1 != null)
			cst1.close();
		closeConnection();
	}


	
	
	
	
	
	
	
	
	
	
}
