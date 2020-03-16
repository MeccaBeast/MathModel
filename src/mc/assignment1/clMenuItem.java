package mc.assignment1;

// interface for menu item
// @auther    Mark
// @version   2018-04-18

final public class clMenuItem implements ifMenuItem {

	// internal variables
	final private int optionNum;
	final private String command;
	final private String title;
	
	
	// constructor
	public clMenuItem(int optionNum, String command, String title) {
		this.optionNum = optionNum;
		this.command = command;
		this.title = title;
	}
	

	public int getOption() {
		return this.optionNum;
	}
		
	public String getCommand() {
		return this.command;
	}
	 	
	
	public String getTitle() {
		return this.title;
	}
	
	public int checkCommand(String command) {
		if (command.equals(this.command)) {
			return this.optionNum;
		} else {
			return -1;
		}
	}
}
	
	