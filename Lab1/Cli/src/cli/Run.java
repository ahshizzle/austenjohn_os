package cli;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import header.CliCommand;
import header.ProcessList;
import header.Process;

public class Run extends CliCommand
{
    @Override
    public String execute(String[] args, ProcessList list)
    {
	Process current = null;
	PrintWriter out = null;
	String result = "";

	try
	{
	    // Instantiate a PrintWriter object:
	    out = new PrintWriter(new FileWriter(args[0] + ".bat"));
	}
	catch (IOException e)
	{
	    return "Cli/Run.java: " + e.toString();
	}

	while (!list.isEmpty())
	{
	    current = list.peek();
	    list.deQueue();
	    try
	    {
		result += current.run(out);
	    }
	    catch (InstantiationException | IllegalAccessException e)
	    {
		return "Run.java: " + e.toString();
	    }
	}

	// Close the Print Writer:
	out.close();

	// Output completion status:
	return result;
    }
}