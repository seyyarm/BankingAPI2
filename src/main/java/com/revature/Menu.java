package com.revature;

import java.util.Scanner;

public class Menu {
	
	public void display_menu() {
	    System.out.println ( "1) For Customers Tap 1\n2) For Employess Tap 2\n3) For Bank Admin Tap 3\n3) To Exit Tap 0" );
	    System.out.print ( "Selection: " );
	    
	    Scanner in = new Scanner ( System.in );
	    
	    switch ( in.nextInt() ) {
	      case 0:
		    System.out.println ( "You picked option 0" );
		    break;
	      case 1: // Customer Menu
	        CustomerMenu cm = new CustomerMenu();
	        cm.display_menu_Customer();
	        break;
	      case 2: //Employee Menu
	        EmployeeMenu em = new EmployeeMenu();
	        em.display_menu_Employee();
	        break;
	      case 3: //Bank Admin Menu
	        AdminBankMenu abm =new AdminBankMenu();
	        abm.displayAdminBankMenu();
	        break;
	      default:
	        System.err.println ( "Unrecognized option" );
	        break;
	  }
	    System.out.println("log off : Bye!!");
	}
	public Menu() {
		display_menu();
	}

}
