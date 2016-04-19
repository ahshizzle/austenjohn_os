package cli;

import java.io.IOException;

import header.CliCommand;
import header.Process;
import header.ProcessList;

public class Add extends CliCommand
{
    public Add() {
		super("Add");
		// TODO Auto-generated constructor stub
	}

	@Override
    public String execute(String[] args, ProcessList list)
    {
	long pid = System.currentTimeMillis() % 100000; // Create unique ID.
	int priority = Thread.NORM_PRIORITY;
	Process current = null;

	try
	{
	    current = new Process(args, priority, pid);
	    //Class.forName("programs." + current.getName());
	}
	catch (ClassNotFoundException | IOException e)
	{
	}

	list.enQueue(current);
	return "process " + current.getName() + " added to batch";
    }
}