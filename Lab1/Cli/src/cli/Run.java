package cli;

import java.io.FileWriter;
import java.io.PrintWriter;

import header.CliCommand;
import header.ProcessList;
import header.Program;
import header.Process;

public class Run extends CliCommand
{
    @Override
    public String execute(String[] args, ProcessList list)
    {
	Program classInstance = null;
	Class<?> className = null;
	Process current = null;
	String print = "";
	PrintWriter out = null;
	try
	{
	    // Instantiate a PrintWriter object:
	    out = new PrintWriter(new FileWriter(args[0] + ".bat"));
	    while (!list.isEmpty())
	    {
		try
		{
		    current = list.peek();
		    String data = current.getName() + " " + String.join(" ", current.getArgs());
		    String[] argData = data.split(" ");

		    // Get the byte code from program to be run:
		    list.deQueue();
		    className = Class.forName("programs." + current.getName());

		    // Make a class instance:
		    classInstance = (Program) className.newInstance();

		    // Call the run method:
		    int classExecuted = classInstance.run(out, argData);
		    if (classExecuted == 0)
			print += current.getName() + " ran successfully time = " + current.getRunTime() + "\n";
		    else
			print += current.getName() + " ran unsuccessfully." + "\n";
		}
		catch (Throwable t)
		{
		    // The class file did not exist, handle the exception:
		    print += current.getName() + " ran unsuccessfully." + "\n";
		}
	    }
	}
	catch (Exception e)
	{
	    // TODO Auto-generated catch block
	    return e.toString();
	}

	// Close the Print Writer:
	out.close();

	// Output completion status:
	return print;
    }
}
