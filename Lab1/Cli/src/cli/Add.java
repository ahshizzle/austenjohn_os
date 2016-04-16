package cli;

import header.CliCommand;
import header.ProcessList;

public class Add extends CliCommand
{
	long pid = System.currentTimeMillis() % 100000;//create unique id
	public Add()
	{
		super();
	}
	
	//System.currentTimeMillis()
	public String execute(String args, ProcessList list) {
		// TODO Auto-generated method stub
		return null;
	}
}
