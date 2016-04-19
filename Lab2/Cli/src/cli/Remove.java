package cli;

import header.CliCommand;
import header.Process;
import header.ProcessList;

public class Remove extends CliCommand
{
    public Remove() {
		super("Remove");
		// TODO Auto-generated constructor stub
	}
	
    @Override
    public String execute(String[] args, ProcessList list)
    {
	long id = Long.parseLong(args[0]);
	Process current = list.remove(id);
	
	if (current != null)
	{
	return "Process Removed\n" +
	       current.getName() +
	       " Id = " + current.getId() + 
	       " Status/time = " + current.getStatus() +
	       " " + current.getRunTime() +
	       " Priority = " + current.getPriority() +
	       " args = " + String.join(" ", current.getArgs());
	}
	else
	    return "Process was not found";
    }
}
