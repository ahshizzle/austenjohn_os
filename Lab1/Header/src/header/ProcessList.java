package header;

public class ProcessList 
{

	private Process     head;
	private Process     tail;

	public ProcessList() // Constructor.
	{
		head = null;
		tail = null;
	}
	
	public Process setPriority(long id, int priority)
	{
		// Change priority.
		return head;
	}
	
	public String toString()
	{
		return "string";
	}
	
	public boolean isEmpty() 
	{
		// Check if queue is Empty.
		return true;
	}
	
	public Process peek()      
	{
		// Return the process at the head.
		return head;
	}
	
	public void enQueue(Process p) // // Add process to the tail. "ADD NODE"
	{
		if (head == null)
		{
			head = p;
			head.previous = null;
			head.next = null;
		}
		else
		{
			tail = head;
			while (tail.next != null)
			{
				tail = tail.next;
			}
			tail.next = p;
			p.previous = tail;
			p.next = null;
		}
	}
	
	public Process deQueue()      
	{
		// Remove from the head.
		return head;
	}
	public Process remove(long id) // Remove process from the list. "DELETE NODE"
	{
		Process current = null;
		if (!(current == find(id)))
		{
			return null;
		}
		else
		{
			Process p = current.previous;
	        Process n = current.next;

	        //Connect next node and previous node
	        if(p != null)
	        {
	          n.previous = p;
	        }
	        else
	        {
	        	head = n; 
	        }

	        //Connect previous node and next node
	        if(n != null)
	        {
	        	p.next = n;
	        }
	        else
	        {
	        	p.next = null; 
	        }
	    }
		
		/*if (head == current) // Root.
			head = current.next;
		else if (head.next == null) // ProcessList only have 2 nodes.
			head.next = current;
		else if (current.next != null) // CurrentProcess has next Process.
			current = current.next;
		else
		*/
			
		return current;
	}
	
	public Process find(long id) // Find process in the queue. "FIND NODE"
	{
		Process current = head;
		while (current != null)
		{
			if (current.getId() == id)
				return current;
			else
				current = current.next;
		}
		return null;
	}
}
