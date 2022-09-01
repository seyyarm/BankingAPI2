package com.revature;

import java.util.List;
import java.util.Scanner;

import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoInterface;
import com.revature.repository.EmployeeDao;
import com.revature.repository.EmployeeDaoInterface;
import com.revature.repository.DTO.AccountDTO;

public class AdminBankMenu {
	AdminBankMenu(){
		
	}
	
	ConnectAUser connectUser = new ConnectAUser();
	AccountDaoInterface aDao = new AccountDao();
	List<AccountDTO> accountList = aDao.selectAllAccount();
	EmployeeDaoInterface eDao = new EmployeeDao();
	
	public void displayAdminBankMenu() {

	  	int userId = 0;
	  	int accountId = 0;
	  	int transType = 0;
	  	userId = connectUser.connectNewUser();
	  	
	    System.out.println ( "1) Applay to open Account : 1\n2) Withdraw 2\n3) deposit : 3\n4) Transfer : 4" );
	    System.out.println ( "5) Display Customers Accounts and Balances : 5\n6) Approve Account 6:\n7) Deny Account 7: " );
	    System.out.println("8) Canceling accounts : 8\n9) To Exit Tap 0");
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
			      case 1: // Open Account
			  			aDao.openAccount(userId);
			  			//displayAdminBankMenu();
			        break;
			        
			      case 2: //Withdraw account
			    	    transType = in.nextInt();
				   		 for (AccountDTO account : accountList) 
				   	      { 		      
				   	          System.out.println(account); 		
				   	      }   	
				        System.out.println ( "Enter the Account Id : " );
				        accountId = in.nextInt();
				        aDao.withdraw(userId, accountId, transType);
				        //displayAdminBankMenu();
			        break;
			        
			      case 3: //Deposit
			    	  	transType = in.nextInt();
			    		
				   		 for (AccountDTO account : accountList) 
				   	      { 		      
				   	          System.out.println(account); 		
				   	      }   	
				        System.out.println ( "Enter the Account Id : " );
				        accountId = in.nextInt();
				        aDao.deposit(userId, accountId, transType);
				        //displayAdminBankMenu();
			        break;
			        
			      case 4: //Transfer
			    	  	//transType = in.nextInt();
				        System.out.println ( "This Function is not ready !! " );
				        //displayAdminBankMenu();
			        break;
			    		        
			      case 5: // Display Customers Accounts and balance
			    	  eDao.displayCustomersAccountBalance(userId);
			    	  //displayAdminBankMenu();
			        break;
			        
			      case 6: //Approve Account
			    	  System.out.println("List of account non approved !!");
			    	  aDao.selectNoActiveAccount();
			    	  System.out.println("Enter the account Id to Approve : ");
			    	  accountId = sc.nextInt();
			    	  eDao.approveAccount(accountId,userId);
			    	  //displayAdminBankMenu();

			        break;
			        
			      case 7: //Deposit
			    	  System.out.println("List of open account !!");
			    	  aDao.selectActiveAccount();
			    	  System.out.println("Enter the account Id to deny : ");
			    	  accountId = sc.nextInt();
			    	  eDao.denyAccount(accountId, userId);
			    	  //displayAdminBankMenu();
			    	  	
			        break;
			        
			      case 8: //canceling account
			    	  aDao.selectActiveAccount();
			    	  System.out.println("Enter the account Id to cancel !!");
			    	  accountId = sc.nextInt();
			    	  eDao.deleteAccount(accountId);
			    	  //displayAdminBankMenu();
			    	  	
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
