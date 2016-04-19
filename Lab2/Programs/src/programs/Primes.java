package programs;

// Class to simulate a run time program.
// Generates list of the first n prime numbers.
import java.io.PrintWriter;

import header.Program;

public class Primes extends Program
{
    private static final long serialVersionUID = 1L;

    public Primes()
    {
	super("Prime Numbers Generator");
    }

    public int run(PrintWriter out, String[] args) throws  InterruptedException
    {
	long maxNumber = Long.parseLong(args[1]);
	if (maxNumber < 1)
	    return (ILLEGAL_PARAMETER);

	out.println(args[0] + ": List of the first " + maxNumber + " primes");
	if (maxNumber >= 1)
	    out.println(2);

	boolean isPrime = true;
	long currentNumber = 3;
	for (int i = 2; i <= maxNumber;) //Need to add schedule call
	{
	    for (int j = 2; j <= Math.sqrt(currentNumber); j++)
	    {
		if (currentNumber % j == 0)
		{
		    isPrime = false;
		    break;
		}
	    }
	    if (isPrime != false)
	    {
		out.println(currentNumber);
		i++;
	    }
	    isPrime = true;
	    currentNumber++;
	}
	return SUCCESS;
    }
}