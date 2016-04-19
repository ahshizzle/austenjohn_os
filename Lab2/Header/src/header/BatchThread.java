package header;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class BatchThread extends Thread
{
	private String      batchName;  // The name of this batch.
	private String      fileName;   // The file where to direct output.
	private long        limit;      // Time limit.
	private ProcessList runList;    // The processes queued to the batch.

	OutputStream outputStream;
	MaxTime maxTime;
	Thread thread;
	
	// Constructor method.
	public BatchThread(String batchName, String fileName, long limit 
	                                   , ProcessList runList)
	{
		this.batchName = batchName;
		this.fileName = fileName;
		this.limit = limit;
		this.runList = runList;
	}
	
	//If finishes in designated time allowed then interrupt the timer thread and then join
	public void run()//May accept arguments or return *CHECK*
	{
		try
		{
		// Instantiate the batch output stream:
		outputStream = new FileOutputStream(fileName);
	
		// Instantiate and starts an instance of the MaxTime thread (see below):
		MaxTime maxTime = new MaxTime(thread, limit);
		
		while (!runList.isEmpty())
		{
			Process current = runList.peek();
			thread.setPriority(current.getPriority());
			
			// Output an appropriate start message:
			String string = "Start message";
			
			// Call the process run method:
			//current.(outputStream);
			
			// Perform a dequeue operation on the Queue
			runList.deQueue();
			
			// Output an appropriate process completion message:
			string += "Completion message.";
			
			// Terminate the MaxTime object, close the output stream:
			maxTime.interrupt();
			maxTime.join();
			outputStream.close();
		}
		}
		catch (Exception e)
		{
			//return ("InterruptedException");
		}
	}
}
