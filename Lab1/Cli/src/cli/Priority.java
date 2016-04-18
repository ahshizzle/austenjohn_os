package cli;

import header.CliCommand;
import header.ProcessList;
import header.Process;

// Change the priority of a particular java class.
// (priority <id> <newPriority>).
// Valid priorities are from Thread.MIN_PRIORITY to Thread.MAX_PRIORITY - 1.
public class Priority extends CliCommand
{

    @Override
    public String execute(String[] args, ProcessList list)
    {
	int priority = Integer.parseInt(args[1]);
	if (priority <= 9 && priority >= 1)
	{
	    Process current = list.setPriority(Long.parseLong(args[0]), priority);
	    return "Process Removed\n" +
	    	   current.getName() +
		   " Id = " + current.getId() + 
		   " Status/time = " + current.getStatus() +
		   " " + current.getRunTime() +
		   " Priority = " + current.getPriority() +
		   " args = " + String.join(" ", current.getArgs());
	}
	else
	    return "Priority must be between 1 and 9";
    }

}
