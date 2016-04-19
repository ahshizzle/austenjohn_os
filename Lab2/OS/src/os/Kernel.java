package os;

import console.CommandListener;
import console.OSConsole;
import header.CliCommand;
import header.ProcessList;

public class Kernel implements CommandListener
{
    OSConsole	console;
    ProcessList	list;

    public static void main(String[] args)
    {
    	new Kernel();
    }

    public Kernel()
    {
    	list = new ProcessList();
		console = new OSConsole("Batch Sequencer");
		console.setCommandListener(this);
		console.write("--->>");
    }

    @Override
    public void commandReceived(String commandString)
    {
		try
		{
		    String[] args = null;
		    try
		    {
				// Split the string into an array:
				String[] argData = commandString.split(" ");
		
				// Create an array understood by CLI methods:
				args = new String[argData.length - 1];
				System.arraycopy(argData, 1, args, 0, args.length);
		
				// Get byte code of CLI command:
				String stringName = Character.toUpperCase(argData[0].charAt(0)) + argData[0].substring(1);
				Class<?> className = Class.forName("cli." + stringName);
		
				// Instantiate the command:
				CliCommand classInstance = (CliCommand) className.newInstance();//This needs to create instance of program
		
				// Call the command's run method:
				String classExecuted = classInstance.execute(args, list);
				console.writeLine(classExecuted);
				console.write("--->>");
			    }
			    catch (ClassNotFoundException c)
			    {
				console.writeLine("java.lang.ClassNotFoundException couldn't add " + args[0] + " to the batch\n");
				console.write("--->>");
		    }
		}
		catch (StringIndexOutOfBoundsException e)
		{
		    console.write("--->>");
		}
		catch (NullPointerException n)
		{
			console.writeLine("a batch has not been started");
			console.write("--->>");
		}
		catch (Throwable t)
		{
		    console.writeLine(t.toString());
		    //console.writeLine("Command failed");
		    console.write("--->>");
		}
    }
}
