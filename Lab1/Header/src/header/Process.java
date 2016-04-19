package header;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Process
{
    public static final int RUNNING    = 0;
    public static final int WAIT       = 1;
    public static final int IDLE       = 2;

    public static final int TERMINATED = 3;

    public static final int ABORTED    = 4;

    private String[]	    args;	   // The calling arguments.
    private long	    id;		   // Process Id number (pid).
    private int		    priority;	   // Priority.
    private long	    startTime;	   // Process start time.

    private long	    endTime;	   // End time after process completes.
    private int		    status;	   // Process status.

    Class<?>		    className;	   // Bytecode name of class.
    Program		    classInstance; // Class instance that can be called.

    public Process	    next;	   // Links for next and previous list entries.
    public Process	    previous;

    // Constructors and methods.
    public Process(String[] args, int priority, long id) throws ClassNotFoundException, IOException
    {
	this.args = args;
	this.priority = priority;
	this.id = id;
	status = IDLE;
	next = null;
	previous = null;
	className = Class.forName("programs." + getName());
    }

    public String run(PrintWriter out) throws InstantiationException, IllegalAccessException
    {
	// Make a class instance:
	classInstance = (Program) className.newInstance();

	// Call the run method:
	int result = classInstance.run(out, args);

	if (result == 0)
	    return getName() + " ran successfully time = " + getRunTime() + "\n";
	else
	    return getName() + " ran unsuccessfully." + "\n";
    }

    public void setPriority(int priority)
    {
	this.priority = priority;
    }

    public long getId()
    {
	return id;
    }

    public int getPriority()
    {
	return priority;
    }

    public String getName()
    {
	return args[0];
    }

    public String[] getArgs()
    {
	String[] argument = Arrays.copyOfRange(args, 1, args.length);
	return argument;
    }

    public long getRunTime()
    {
	if (startTime == 0)
	    return 0;
	else if (status == RUNNING)
	    return System.currentTimeMillis() - startTime;
	else
	    return endTime - startTime;
    }

    public String getStatus()
    {
	if (status == RUNNING)
	    return "Running";
	else if (status == WAIT)
	    return "Wait";
	else if (status == IDLE)
	    return "Idle";
	else if (status == TERMINATED)
	    return "Terminated";
	else
	    return "Aborted";
    }

    public String toString()
    {
	String joinedArgs = String.join(" ", getArgs());
	String joinedStrings = String.format("%-5s", getName()) + "\t" + String.format("%-5d", getId()) + "\t"
		+ String.format("%-5s", getStatus()) + "\t" + String.format("%-5d", getRunTime()) + "\t"
		+ String.format("%-5d", getPriority()) + "\t" + String.format("%-5s", joinedArgs) + "\n";
	return joinedStrings;
    }
}
