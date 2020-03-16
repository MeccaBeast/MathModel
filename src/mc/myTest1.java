package mc;
import mc.assignment1.*;
import java.util.*;

class myTest1
{
	
	public static void main(String args[])
	{	
	    // declare variables
	    int menuchoice;
		
		// create main menu items
		clMenuItem[] mainMenuItems = new clMenuItem[3];
		mainMenuItems[0] = new clMenuItem(0,"x","Exit Program");
		mainMenuItems[1] = new clMenuItem(1,"r","Linear Regression");
		mainMenuItems[2] = new clMenuItem(2,"f","Free Fall Computer");
		
		clMenuItem[] subMenuItems1 = new clMenuItem[4];
		subMenuItems1[0] = new clMenuItem(0,"r","Return");
		subMenuItems1[1] = new clMenuItem(1,"l","Load from CSV file");
		subMenuItems1[2] = new clMenuItem(2,"p","Print table");
		subMenuItems1[3] = new clMenuItem(3,"c","Compute values");
		 
		clMenuItem[] subMenuItems2 = new clMenuItem[4];
		subMenuItems2[0] = new clMenuItem(0,"r","Return");
		subMenuItems2[1] = new clMenuItem(1,"l","Load from CSV file");
		subMenuItems2[2] = new clMenuItem(2,"p","Print table");
		subMenuItems2[3] = new clMenuItem(3,"c","Compute values");
		
		long computeTime=0;
		
		// create 3 menus
		clMenu mainMenu = new clMenu("MAIN MENU",mainMenuItems);
		clMenu subMenu1 = new clMenu("Linear Regression Menu",subMenuItems1);
		clMenu subMenu2 = new clMenu("Freefall Menu",subMenuItems2);
		
		// show main menu
		

  		menuchoice = 1;
  		while(menuchoice > 0) {
  		    mainMenu.showMenu("Assignment 1","Main Menu");
  		    menuchoice = mainMenu.getOption();
  		    
   			switch(menuchoice) {
   			
   			    // go to linear regression sub menu
   				case 1: sub1(subMenu1);
    				    break;
    			
    			// go to free fall sub menu
   				case 2:	sub2(subMenu2);
   				        break;
    		}
   		}
   		// exit program
   		System.out.println("See you next time!");
	}
	
	
	public static void sub1(clMenu subM1) {
	
  		int menuchoice = 1;
  		// create a table object to test
	    LinearTable myTable1 = new LinearTable();
	    
	    
  		while(menuchoice>0) {
  		    subM1.showMenu("Assignment 1","Linear Regression");
  		    menuchoice = subM1.getOption();
  		    
   			switch(menuchoice) {
   			
   			    // load csv
   				case 1:
   				subM1.showMenu("Assignment 1","Linear Regression"); 
   				myTable1.loadCSV();
   				System.out.println("------continue------");
   				new Scanner(System.in).nextLine();
    				    break;
    			
    			// print table
   				case 2: 
   				subM1.showMenu("Assignment 1","Linear Regression");
   			   
   				myTable1.showTable();
   				System.out.println("------continue------");
   				new Scanner(System.in).nextLine();
   				        break;

    			// compute
   				case 3: 
   				subM1.showMenu("Assignment 1","Linear Regression");
   				
   				myTable1.printResults();
   				System.out.println("------continue------");
   				new Scanner(System.in).nextLine();
   				
   				        break;
   				default:
   				subM1.showMenu("Assignment 1","Linear Regression");
   				break;
    			}
   		}
   	    
	}
	
	public static void sub2(clMenu subM2) {
	
  		int menuchoice = 1;
  		// create a table object to test
	    FreefallTable myTable2 = new FreefallTable();
	    
	    
  		while(menuchoice > 0) {
  		    subM2.showMenu("Assignment 1","Free Fall");
  		    menuchoice = subM2.getOption();
  		    
   			switch(menuchoice) {
   			
   			// load csv
   				case 1:
   				subM2.showMenu("Assignment 1","Free Fall"); 
   				myTable2.loadCSV();
   				System.out.println("------continue------");
   				new Scanner(System.in).nextLine();
    				    break;
    			
    			// print table
   				case 2: 
   				subM2.showMenu("Assignment 1","Free Fall");
   				myTable2.showTable();
   				System.out.println("------continue------");
   				new Scanner(System.in).nextLine();
   				        break;

    			// compute
   				
   				case 3: 
   				
   				subM2.showMenu("Assignment 1","Free Fall");
   				myTable2.calculateFreefall();
   				System.out.println("------continue------");
   				new Scanner(System.in).nextLine();
   				        break;
   				default:
   				subM2.showMenu("Assignment 1","Free fall");
   				break;
    			}
   		}
   	    
	}


}
