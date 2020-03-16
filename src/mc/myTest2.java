package mc;
import mc.assignment1.*;
import java.util.Scanner;

class myTest2
{
	
	public static void main(String args[]) {
	
	    System.out.println("test program starting ... ");
	
	    // create a table object to test
	    FreefallTable myTable = new FreefallTable();
	    
	    // insert some test rows
	    myTable.insertTableRow("0,0.1,0.2");
	    myTable.insertTableRow("1,0.3,0.4");
	    myTable.showTable();
	    
	    myTable.loadCSV();
	    myTable.showTable();
	    
	    myTable.calculateFreefall();
	    
	    System.out.println("test program complete .. ");
	}
}
