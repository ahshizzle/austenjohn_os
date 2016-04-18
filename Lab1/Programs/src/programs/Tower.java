package programs;

// Class to simulate a run time program.
// Solves the Tower of Hanoi problem for n disks.
import java.io.PrintWriter;

import header.Program;

public class Tower extends Program
{
    private static final long serialVersionUID = 1L;

    public Tower()
    {
	super("Tower of Hanoi Solver");
    }

    public int run(PrintWriter out, String[] args)
    {
	long maxNumber = Long.parseLong(args[1]);
	if (maxNumber < 1)
	    return (ILLEGAL_PARAMETER);

	out.println(args[0] + ": " + maxNumber + " rings");

	solve(out, maxNumber, "1", "2", "3");
	return SUCCESS;
    }

    private void solve(PrintWriter out, long n, String start, String auxiliary, String end)
    {
	if (n == 1)
	{
	    out.println("Move from " + start + " to " + end);
	}
	else
	{
	    solve(out, n - 1, start, end, auxiliary);
	    out.println("Move from " + start + " to " + end);
	    solve(out, n - 1, auxiliary, start, end);
	}
    }
}