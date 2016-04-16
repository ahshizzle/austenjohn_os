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

	private String[] args;       // The calling arguments.
	private long id;             // Process Id number (pid).
	private int  priority;       // Priority.
	private long startTime;      // Process start time.

	private long endTime;        // End time after process completes.
	private int  status;         // Process status.

	@SuppressWarnings("rawtypes")
	Class   className;           // Bytecode name of class.
	Program classInstance;       // Class instance that can be called.

	public Process next;         // Links for next and previous list entries.
	public Process previous;

	// Constructors and methods.
	public Process(String[] args, int priority, long id)
			throws ClassNotFoundException, IOException
	{
		this.args = args;
		this.priority = priority;
		this.id = id;
	}
    public String run(PrintWriter out)
    		throws InstantiationException, IllegalAccessException
    {
    	try
        {     
            className = Class.forName(args[0]);  // Call the class loader to load and compile the program
        }
    	catch (Throwable t)
        { 
            // The class file did not exist, handle the exception
    		return getName() + " ran unsuccessfully.";
        }
        classInstance = (Program)className.newInstance();  // Instantiate the class file
        classInstance.run(out, args);  // Call the program’s run method
        
		return getName() + " ran successfully time = " + getRunTime();
    }
    public void setPriority(int priority)
    {
		priority = 5;
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
    	String[] argument = Arrays.copyOfRange(args, 1, args.length-1);
    	return argument;
    }
    public long getRunTime()
    {
    	if (startTime == 0)
    	{
    		return 0;
    	}
    	else if (status == RUNNING)
    	{
    		return System.currentTimeMillis() - startTime;
    	}
    	else
    	{
    		return endTime - startTime;
    	}
    }
    public String getStatus()
    {
    	if (status == RUNNING)
    		return "running";
    	else if (status == WAIT)
    		return "wait";
    	else if (status == IDLE)
    		return "idle";
    	else if (status == TERMINATED)
    		return "terminated";
    	else
    		return "aborted";
    }
    public String toString() 
    {
    	//StringJoiner joiner = new StringJoiner(",");
    	//joiner.add(args[1]);
    	//joiner.add(args[2]);
    	//joiner.add(args[3]);
    	//String joined = joiner.toString();
    	// String.join(delimiter, elements);
    	//String joined = String.join(",", value1, value2, value3);
    	//String joined = String.join(" ", args);
    	//String joined = String.join(" ", getName(), Long.toString(getId()), getStatus(), Long.toString(getRunTime()), Int.toString(getPriority(), getArgs());
    	//return joined;
    	String joinedArgs    = String.join(" ", getArgs());
    	String joinedStrings = getName() + " " + getId() + " " +
    						   getStatus() + " " + getRunTime() + " " +
    			               getPriority() + " " + joinedArgs;
    	return joinedStrings;
    }
}
