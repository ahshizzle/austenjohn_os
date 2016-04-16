package os;

import console.CommandListener;
import console.OSConsole;

public class Kernel implements CommandListener
{
	OSConsole console;
	
	public static void main(String[] args)
	{
		new Kernel();
	}
	
	public Kernel()
	{
		console = new OSConsole("Batch Sequencer");
		console.setCommandListener(this);
		console.write("--->>");
	}
	
	@Override
	public void commandReceived(String commandString)
	{
		console.write("--->>");
		
		try
		{
			// To parse a user command line:
			String[] argData = commandString.split(" ");
			String[] args = new String[argData.length-1];
			System.arraycopy(argData, 1, args, 0, args.length);
		}
		catch (Throwable t)
		{
            // The class file did not exist, handle the exception
		}
	}
}
