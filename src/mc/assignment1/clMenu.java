package mc.assignment1;
import java.util.Scanner;

// interface for menu item
// @auther    Mark
// @version   2018-04-18

final public class clMenu implements ifMenu
{

	// internal variables
	
	final private String menuTitle;
	final private clMenuItem[] arrayMenuItems;

	
	// constructor
	public clMenu(String title, clMenuItem[] menuList) {
		this.menuTitle = title;
		this.arrayMenuItems = menuList;
	}
	

	public void showMenu(String header, String footer) {
	
		System.out.println("\033\143");
		System.out.flush();
		
		System.out.println(header);
		System.out.println("");
		
		int numItems = this.arrayMenuItems.length;
		
		for (int i=0;i<numItems;i++) {
			System.out.println(arrayMenuItems[i].getCommand() + " " + arrayMenuItems[i].getTitle());
		}
		
		System.out.println("");

		
		System.out.println(footer);
	
	}


	public int getOption() {
	
		int numItems = this.arrayMenuItems.length;
		int i;
		int option;
		String userCommand;
		String menuCommand;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("enter command: ");
		userCommand = scan.nextLine();
		
		option = -1;
		i = 0;
		
		while ((i<numItems)&&(option<0)) {
			menuCommand = this.arrayMenuItems[i].getCommand();
			if (menuCommand.equals(userCommand)) {
				option = this.arrayMenuItems[i].getOption();
			}
			i++;
		}
			
		if (option < 0 ) {
			System.out.println("no such command");
		}
	
		return option;
	}
}
	
	
