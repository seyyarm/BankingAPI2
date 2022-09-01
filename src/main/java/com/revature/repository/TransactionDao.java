package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.revature.util.ConnectionFactory;

public class TransactionDao implements TransactionDaoInterface{
	
	public TransactionDao () {
		
	}

	@Override
	public void insertTransaction(int transactAmmount, Integer accountId, Integer transacType) {
		
		String sql = "INSERT INTO transactions ( transact_date, transact_ammount, transact_type, account_id) VALUES(?,?,?,?)" ;
		try(Connection connection = ConnectionFactory.getConnection();
				PreparedStatement st1 = connection.prepareStatement(sql);){
			
					st1.setString(1, "8/29/2021");
					st1.setInt(2, transactAmmount);
					st1.setInt(3, transacType);
					st1.setInt(4, accountId);
					st1.execute();
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//consoleLogger.error(e.getMessage());
					//fileLogger.error(e.toString());
				}
		
	}

}
