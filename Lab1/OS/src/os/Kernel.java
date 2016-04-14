package os;

import console.CommandListener;
import console.OSConsole;

public class Kernel implements CommandListener
{
	public void main(String[] args)
	{
		OSConsole console = new OSConsole("Batch Sequencer");
		console.setCommandListener(this);
	}

	@Override
	public void commandReceived(String commandString)
	{
		// Add your code to process each command here
	}
}
