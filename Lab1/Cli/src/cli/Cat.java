package cli;

import java.io.*;

import header.CliCommand;
import header.ProcessList;

public class Cat extends CliCommand
{
	
	public Cat() throws IOException //throws FileNotFoundException
	{
		super();
		try
		{
			String sCurrentLine;
			BufferedReader br = new BufferedReader(new FileReader("C:\\testing.txt"));
			do
			{
				sCurrentLine = br.readLine();
				//console.write(sCurrentLine);
			} while (sCurrentLine != null);
			br.close();
		}
		catch (EOFException eof)
		{
			// catch exception
		}
		catch (Exception e)
		{
			// catch exception
		}
	}

	

	@Override
	public String execute(String args, ProcessList list)
	{
		// TODO Auto-generated method stub
		return null;
	}
}