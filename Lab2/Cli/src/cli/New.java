package cli;

import header.CliCommand;
import header.ProcessList;

public class New extends CliCommand // Start a new batch queue of jobs. (new)
{
    public New() {
		super("New");
		// TODO Auto-generated constructor stub
	}
	
    @Override
    public String execute(String[] args, ProcessList list)
    {
    	//list = new ProcessList(args[0]);
    	//return list.getName() + " initialized";
    	
		while (!list.isEmpty())
		   list.deQueue();
		return "New batch initialized";
    }
}