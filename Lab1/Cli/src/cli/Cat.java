package cli;

import java.io.BufferedReader;
import java.io.FileReader;
import header.CliCommand;
import header.ProcessList;

public class Cat extends CliCommand
{
    @Override
    public String execute(String[] args, ProcessList list)
    {
	String data;
	try
	{
	    BufferedReader reader = new BufferedReader(new FileReader(args[0]));
	    String line = reader.readLine();
	    data = line + "\n";
	    while (line != null)
	    {
		line = reader.readLine();
		if (line != null)
		    data += line + "\n";
	    }	    
	    reader.close();
	}
	catch (Exception e)
	{
	    return "Couldn't open file " + args[0];
	}
	return data;
    }
}