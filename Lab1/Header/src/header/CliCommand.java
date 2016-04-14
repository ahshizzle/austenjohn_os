package header;

import os.ProcessList;

public abstract class CliCommand
{
	public abstract String execute(String args, ProcessList list);
}