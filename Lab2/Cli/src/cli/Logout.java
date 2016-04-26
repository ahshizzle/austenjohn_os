package cli;

import header.CliCommand;
import header.ProcessList;

public class Logout extends CliCommand
{
    @Override
    public String execute(String[] args, ProcessList list)
    {
	// TODO Auto-generated method stub
	System.exit(0);
	return null;
    }
}
