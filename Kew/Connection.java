public class Connection
{	
	private static int number=0;
	public Connection()
	{
		this.number++;
	}

	public void disconnect()
	{
		this.number--;
	}

	public void display()
	{
		System.out.println(this.number);
	}


}