package header;

public abstract class CliCommand
{
    public abstract String execute(String[] args, ProcessList list);
}