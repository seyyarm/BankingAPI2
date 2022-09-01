package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.repository.AccountDao;
import com.revature.repository.AccountDaoInterface;
import com.revature.repository.DTO.AccountDTO;

public class CustomerMenu {
	public CustomerMenu() {
	}

	ConnectAUser connectUser = new ConnectAUser();
	AccountDaoInterface aDao = new AccountDao();
	List<AccountDTO> accountList = aDao.selectAllAccount();
	
	public void display_menu_Customer() {


	  	int userId = 0;
	  	int accountId = 0;
	  	int transType = 0;
	  	userId = connectUser.connectNewUser();
	  	
	    System.out.println ( "1) Applay to open Account : 1\n2) Withdraw 2\n3) deposit : 3\n4) Transfer : 4\n5) To Exit Tap 0" );
	    System.out.print ( "Selection: " );
	    
	    Scanner in = new Scanner ( System.in );
	    
	    do {
		    if (userId != 0) {
		    	switch ( in.nextInt() ) {
			      case 0:
			    	  Menu m = new Menu();
			    	  m.display_menu();
				    break;
				    
			      case 1: // Open Account
			  			aDao.openAccount(userId);
			  			//display_menu_Customer();
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
				        
				        //display_menu_Customer();
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
				        //display_menu_Customer();
			        break;
			        
			      case 4: //Transfer
			    	  	//transType = in.nextInt();
				        System.out.println ( "This Function is not ready !! " );
				        //display_menu_Customer();
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
