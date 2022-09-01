package com.revature;

import java.util.List;
import java.util.Scanner;

import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoInterface;
import com.revature.repository.EmployeeDao;
import com.revature.repository.EmployeeDaoInterface;
import com.revature.repository.DTO.AccountDTO;
import com.revature.repository.DTO.EmployeeDTO;

public class EmployeeMenu {
	public EmployeeMenu() {
		
	}
	ConnectAUser connectUser = new ConnectAUser();
	EmployeeDaoInterface eDao = new EmployeeDao();
	AccountDaoInterface aDao = new AccountDao();
	public void display_menu_Employee() {

	  	int userId = 0;
	  	int accountId = 0;
	  	int transType = 0;
	  	userId = connectUser.connectNewUser();
	  	
	    System.out.println ( "1) Display Customers Accounts and Balances : 1\n2) Approve Account 2\n3) Deny Account : 3\n4) To Exit Tap 0" );
	    System.out.print ( "Selection: " );
	    
	    Scanner in = new Scanner ( System.in );
	    Scanner sc = new Scanner ( System.in );

	    do {
		    if (userId != 0) {
		    	switch ( in.nextInt() ) {
			      case 0:
				   // System.out.println ( "You picked option 0 so exit" );
			    	  Menu m = new Menu();
			    	  m.display_menu();
				    break;
			      case 1: // Display Customers Accounts and balance
			    	  eDao.displayCustomersAccountBalance(userId);
			    	  //display_menu_Employee();
			        break;
			        
			      case 2: //Approve Account
			    	  System.out.println("List of account non approved !!");
			    	  aDao.selectNoActiveAccount();
			    	  System.out.println("Enter the account Id to Approve : ");
			    	  accountId = sc.nextInt();
			    	  eDao.approveAccount(accountId,userId);
			    	  //display_menu_Employee();

			        break;
			        
			      case 3: //Deposit
			    	  System.out.println("List of open account !!");
			    	  aDao.selectActiveAccount();
			    	  System.out.println("Enter the account Id to deny : ");
			    	  accountId = sc.nextInt();
			    	  eDao.denyAccount(accountId, userId);
			    	  //display_menu_Employee();
			    	  	
			        break;
			        
			      default:
			        System.err.println ( "Unrecognized option" );
			        break;
			  }
		    }else {
		    	System.out.println("Error : UserName or Password ");
		    	
		    }
	    	
	    }while(in.nextInt()==0);
	    // return to Menu
	    Menu m = new Menu();
	    m.display_menu();

	    
	}

}
