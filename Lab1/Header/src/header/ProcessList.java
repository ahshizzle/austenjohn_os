package header;

public class ProcessList
{

    private Process head;
    private Process tail;

    public ProcessList() // Constructor.
    {
	head = null;
	tail = null;
    }

    public Process setPriority(long id, int priority) // Change priority.
    {
	Process p = find(id);
	p.setPriority(priority);
	return p;
    }

    public String toString()
    {
	Process current = head;
	String list = "";

	if (isEmpty() == true) // If ProcessList is empty.
	    return null; // Then return nothing.

	list += current.toString();//adds current toString to list
	while (current.next != null)
	{
	    current = current.next;
	    list += current.toString();
	}

	return list;
    }

    public boolean isEmpty() // Check if queue is Empty.
    {
	if (head != null)
	    return false;
	else
	    return true;
    }

    public Process peek() // Return the process at the head.
    {
	return head;
    }

    public void enQueue(Process p) // Add process to the tail.
    {
	if (isEmpty() == true)
	{
	    head = p;
	    head.previous = null;
	    head.next = null;
	    tail = head;
	}
	else
	{
	    tail.next = p; // Add new Process in next Process of Tail.
	    p.previous = tail; // Connect new Process to old Tail.
	    tail = p; // Make the new Process the new Tail.
	    p.next = null; // Set next Process of new Process to empty.
	}

    }

    public Process deQueue() // Remove from the head.
    {
	remove(head.getId());
	return head;
    }

    public Process remove(long id) // Remove process from the list.
    {
	Process current = find(id);

	if (current == null) // If current Process is null.
	    return null;

	if (current == head) // If Process is Head.
	{
	    head = current.next;

	    if (current.next != null) // More than 1 Process in the List
		current.next.previous = null;

	    if (current == tail) // Only 1 Process in the List.
		tail = null;
	}
	else if (current == tail) // If Process is Tail.
	{
	    tail = tail.previous;
	    current.previous.next = null;
	}
	else // If Process is not Head or Tail.
	{
	    current.next.previous = current.previous;
	    current.previous.next = current.next;
	}

	return current;
    }

    public Process find(long id) // Find process in the queue.
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
