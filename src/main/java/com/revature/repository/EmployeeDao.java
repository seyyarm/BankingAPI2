package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import com.revature.repository.DTO.AccountDTO;
import com.revature.repository.DTO.EmployeeDTO;
import com.revature.util.ConnectionFactory;

public class EmployeeDao implements EmployeeDaoInterface{
	
	public static void main(String[] args) {
		EmployeeDao eDao = new EmployeeDao();
		System.out.println(eDao.selectEmployeeById(2));
	
		List<EmployeeDTO> employeesList = eDao.selectEmployee();
		
		 for (EmployeeDTO employee : employeesList) 
	      { 		      
	          System.out.println(employee); 		
	      }   	
		
	}

	@Override
	public EmployeeDTO selectEmployeeById(Integer employeeId) {
		EmployeeDTO employee = null;
		
		final String sql = "SELECT * FROM employees WHERE employee_id = '"+employeeId+"';";

		
		try (Connection connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();)
		{
			ResultSet set = statement.executeQuery(sql);
			
			if(set.next()) {
				employee = new EmployeeDTO(
						set.getInt(1),
						set.getString(2),
						set.getInt(3)	
						);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//consoleLogger.error(e.getMessage());
			//fileLogger.error(e.toString());
		}
		
		return employee;

	}


	@Override
	public List<EmployeeDTO> selectEmployee() {
		
		EmployeeDTO employee =null;
		List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>();
		
		final String sql = "SELECT * FROM employees ";
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
				while(set.next()) {
					 employee = new EmployeeDTO(
							set.getInt(1),
							set.getString(2),
							set.getInt(3)
							);
					// System.out.println("\n");
					employeeList.add(employee);
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//consoleLogger.error(e.getMessage());
				//fileLogger.error(e.toString());
			}
		
		return employeeList;
	}

	@Override
	public void displayCustomersAccountBalance(Integer userId) {
		
		AccountDTO account =null;
		List<AccountDTO> accountList = new ArrayList<AccountDTO>();
		
		final String sql = "select accounts.account_id,account_type ,balance , created_on, is_active, acc_number\r\n"
				+ "from accounts, users, users_acc_bridg uab\r\n"
				+ "where users.user_id = uab.user_id  ";
		//and uab.user_id = '"+userId+"';
		
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
	public void approveAccount(Integer accountId, Integer userId) {
		String sql = "UPDATE accounts "
                + "SET is_active = ?"
                + "WHERE account_id = ?";
		try (Connection connection = ConnectionFactory.getConnection();
				
				PreparedStatement st = connection.prepareStatement(sql);
				){
			st.setBoolean(1, true);
			st.setInt(2, accountId);
			st.executeUpdate();
			System.out.println("Account Number :"+ accountId +" is approved");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//consoleLogger.error(e.getMessage());
			//fileLogger.error(e.toString());
		}
		
	}

	@Override
	public void denyAccount(Integer accountId, Integer userId) {
		String sql = "UPDATE accounts "
                + "SET is_active = ?"
                + "WHERE account_id = ?";
		try (Connection connection = ConnectionFactory.getConnection();
				
				PreparedStatement st = connection.prepareStatement(sql);
				){
			st.setBoolean(1, false);
			st.setInt(2, accountId);
			st.executeUpdate();
			System.out.println("Account Number :"+ accountId +" is deny");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//consoleLogger.error(e.getMessage());
			//fileLogger.error(e.toString());
		}
		
	}

	@Override
	public void deleteAccount(Integer accountId) {
		
		String sql = "DELETE FROM accounts WHERE account_id = ?";
		try (Connection connection = ConnectionFactory.getConnection();
				
				PreparedStatement st = connection.prepareStatement(sql);
				) {

	            // set the corresponding param
	            st.setInt(1, accountId);
	            // execute the delete statement
	            st.executeUpdate();
	            System.out.println("Account Number :" + accountId + " are deleted");

	        } catch (SQLException e) {
	        	e.printStackTrace();
				//consoleLogger.error(e.getMessage());
				//fileLogger.error(e.toString());
	        }
		
	}
	
	
		

}
