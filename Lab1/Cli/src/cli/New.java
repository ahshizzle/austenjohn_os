package cli;

import header.CliCommand;
import header.ProcessList;

public class New extends CliCommand // Start a new batch queue of jobs. (new)
{
    @Override
    public String execute(String[] args, ProcessList list)
    {
	while (!list.isEmpty())
	    list.deQueue();
	return "New batch initialized";
    }

}