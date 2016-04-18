package cli;

import header.CliCommand;
import header.ProcessList;

public class Queue extends CliCommand //Display the current batch queue. (queue)
{
    @Override
    public String execute(String[] args, ProcessList list)
    {
	String joinedStrings = "Current batch queue\n";
 	       joinedStrings +=  String.format("%-5s", "Name") + "\t";
 	       joinedStrings += String.format("%-5s", "Id") + "\t";
 	       joinedStrings += String.format("%-5s", "Status") + "\t";
 	       joinedStrings += String.format("%-5s", "RunTime") + "\t";
 	       joinedStrings += String.format("%-5s", "Priority") + "\t";
 	       joinedStrings += String.format("%-5s", "Arguments") + "\t" + "\n";
	if (list.isEmpty())
	    return joinedStrings;
	else
	{
	    joinedStrings += list.toString();
	    return joinedStrings;
	}
    }
}
