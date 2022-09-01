package com.revature.repository;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.repository.DTO.AccountDTO;
import com.revature.repository.DTO.TransactionDTO;
import com.revature.services.models.User;
import com.revature.util.ConnectionFactory;

public class AccountDao implements AccountDaoInterface{
	
    Scanner sc = new Scanner(System.in);  // Create a Scanner object
    /*
	
	public static void main(String[] args) {
		AccountDao aDao = new AccountDao();
		aDao.openAccount(null);
		System.out.println(aDao.selectAccountById(2));
	
		List<AccountDTO> accountList = aDao.selectAllAccount();
		
		 for (AccountDTO account : accountList) 
	      { 		      
	          System.out.println(account); 		
	      }   	
		
		

	}*/

	
	@Override
	public AccountDTO selectAccountById(Integer accountId) {
		
		AccountDTO account = null;
		final String sql = "SELECT * FROM accounts WHERE account_id = '"+accountId+"';";

		try (Connection connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();)
		{
			ResultSet set = statement.executeQuery(sql);
			
			if(set.next()) {
				account = new AccountDTO(
						set.getInt(1),
						set.getString(2),
						set.getInt(3),
						set.getString(4),
						set.getBoolean(5),
						set.getString(6)
						);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//consoleLogger.error(e.getMessage());
			//fileLogger.error(e.toString());
		}
		
		return account;
	}

	
	@Override
	public List<AccountDTO> selectAllAccount() {

		AccountDTO account =null;
		List<AccountDTO> accountList = new ArrayList<AccountDTO>();
		
		final String sql = "SELECT * FROM accounts ";
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
				while(set.next()) {
					 account = new AccountDTO(
							 set.getInt(1),
								set.getString(2),
								set.getInt(3),
								set.getString(4),
								set.getBoolean(5),
								set.getString(6)
								);
					// System.out.println("\n");
					accountList.add(account);
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//consoleLogger.error(e.getMessage());
				//fileLogger.error(e.toString());
			}
		
		return accountList;
	
	}

	
	@Override
	public void openAccount(Integer userId) {
		
		String accountType;
		int balance = 0;
		String createdOn ="10/10/2010" ;
		boolean isActive = false;
		String accNumber;
		
		System.out.println("Open a New Account :");
		
		System.out.println("Please input your account TYPE !!:");
		accountType = sc.nextLine();  
		
		System.out.println("Please input your Account Number !!:");
		accNumber = sc.nextLine(); 
		
		System.out.print("Please input your Balance !!:");
		balance = sc.nextInt();  
		
 
		String sql = "INSERT INTO accounts (account_type, balance, created_on, is_active, acc_number) VALUES (?, ?, ?, ?, ?) RETURNING account_id;";
		String sql2 = "INSERT INTO users_acc_bridg (user_id, account_id) VALUES(?,?)" ;
		
		Integer account_id = 0;
		
		try(Connection connection = ConnectionFactory.getConnection();
		PreparedStatement st1 = connection.prepareStatement(sql);
		PreparedStatement st2 = connection.prepareStatement(sql2);
				)
		{
			st1.setString(1, accountType);
			st1.setInt(2, balance);
			st1.setString(3, createdOn);
			st1.setBoolean(4, isActive);
			st1.setString(5, accNumber);
			st1.execute();
			
			ResultSet rs = st1.getResultSet();
			if(rs.next()) {
				account_id = rs.getInt(1);
			}
			
			st2.setInt(1, userId);
			st2.setInt(2, account_id);
			st2.execute();
	        // System.out.println(account_id);

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//consoleLogger.error(e.getMessage());
			//fileLogger.error(e.toString());
		}        
	}

	@Override
	public void withdraw(Integer userId, Integer accountId, Integer transacType) {
		
		
		int oldBalance = 0;
		int newBalance = 0;
		int newWithdraw =0;
		
        System.out.println ( "Enter the amount you want to withdraw from your account  : " );
        newWithdraw = sc.nextInt();
		
		
		//return the Account Id 
		String sql1 = "SELECT * FROM accounts WHERE account_id = '"+accountId+"';";
		//update balance
		String sql2 = "UPDATE accounts "
                + "SET balance = ?"
                + "WHERE account_id = ?";
		
		try (Connection connection = ConnectionFactory.getConnection();
				//PreparedStatement st1 = connection.prepareStatement(sql1);
				Statement st1 = connection.createStatement();
				PreparedStatement st2 = connection.prepareStatement(sql2);
				)
			{
				//return old Balance
				ResultSet set = st1.executeQuery(sql1);
				
				if(set.next()) {
				oldBalance  = set.getInt(3);
				System.out.println(oldBalance);
				}
				//set a new balance
				//ResultSet set2 = st2.executeQuery(sql2);
				newBalance = oldBalance - newWithdraw;
				System.out.println(newBalance);
				st2.setInt(1, newBalance);
				st2.setInt(2, accountId);
				st2.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//consoleLogger.error(e.getMessage());
				//fileLogger.error(e.toString());
			}
		TransactionDao trans = new TransactionDao();
		
		trans.insertTransaction(newWithdraw, accountId, transacType);
		//System.out.println("withdraw bingo!!!!");
		
	}


	@Override
	public void deposit(Integer userId, Integer accountId, Integer transacType) {
		int oldBalance = 0;
		int newBalance = 0;
		int newDeposit =0;
		
        System.out.println ( "Enter the amount you want to deposit to your account  : " );
        newDeposit = sc.nextInt();
		
		
		//return the Account Id 
		String sql1 = "SELECT * FROM accounts WHERE account_id = '"+accountId+"';";
		//update balance
		String sql2 = "UPDATE accounts "
                + "SET balance = ?"
                + "WHERE account_id = ?";
		
		try (Connection connection = ConnectionFactory.getConnection();
				//PreparedStatement st1 = connection.prepareStatement(sql1);
				Statement st1 = connection.createStatement();
				PreparedStatement st2 = connection.prepareStatement(sql2);
				)
			{
				//return old Balance
				ResultSet set = st1.executeQuery(sql1);
				
				if(set.next()) {
				oldBalance  = set.getInt(3);
				System.out.println(oldBalance);
				}
				//set a new balance
				//ResultSet set2 = st2.executeQuery(sql2);
				newBalance = oldBalance + newDeposit;
				System.out.println("New Balance is : "+newBalance);
				st2.setInt(1, newBalance);
				st2.setInt(2, accountId);
				st2.executeUpdate();
				
				
				
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//consoleLogger.error(e.getMessage());
				//fileLogger.error(e.toString());
			}
		TransactionDao trans = new TransactionDao();
		
		trans.insertTransaction(newDeposit, accountId, transacType);
		System.out.println("deposit bingo!!!!");
		
	}


	@Override
	public void selectNoActiveAccount() {
		AccountDTO account =null;
		List<AccountDTO> accountList = new ArrayList<AccountDTO>();
		
		final String sql = "SELECT * FROM accounts where is_active = false";
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
				while(set.next()) {
					 account = new AccountDTO(
							 set.getInt(1),
								set.getString(2),
								set.getInt(3),
								set.getString(4),
								set.getBoolean(5),
								set.getString(6)
								);
					// System.out.println("\n");
					accountList.add(account);
						
				}	
				for (AccountDTO a : accountList) 
		   	      { 		      
		   	          System.out.println(a); 		
		   	      }  
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//consoleLogger.error(e.getMessage());
				//fileLogger.error(e.toString());
			}
		
		
	}


	@Override
	public void selectActiveAccount() {
		AccountDTO account =null;
		List<AccountDTO> accountList = new ArrayList<AccountDTO>();
		
		final String sql = "SELECT * FROM accounts where is_active = true";
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
				while(set.next()) {
					 account = new AccountDTO(
							 set.getInt(1),
								set.getString(2),
								set.getInt(3),
								set.getString(4),
								set.getBoolean(5),
								set.getString(6)
								);
					// System.out.println("\n");
					accountList.add(account);

				}	
				for (AccountDTO a : accountList) 
		   	      { 		      
		   	          System.out.println(a); 		
		   	      } 	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//consoleLogger.error(e.getMessage());
				//fileLogger.error(e.toString());
			}
		
		
	}






}
