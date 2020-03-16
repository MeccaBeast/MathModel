package mc.assignment1;

// interface for menu item
// @auther    Mark
// @version   2018-04-18

public interface ifMenuItem
{
	int getOption();
	
	String getCommand();
	
	String getTitle();
	
	int checkCommand(String command);
}
	
	