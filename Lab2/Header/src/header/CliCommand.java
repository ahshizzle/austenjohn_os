package header;

public abstract class CliCommand
{
    private String	     name;
	
    public CliCommand(String name)
    {
    	this.name = name;
    }

    public String getName()
    {
    	return name;
    }
    
    public abstract String execute(String[] args, ProcessList list);
}