public class problem_5
{
	public static boolean isPrime(int n)
	{
		if(n==0)
			return false;
		else
		{
			for(int i=1;i<n;i++)
			{
				if(n%i==0)
					return false;
			}

			return true;
		}
	}

	public static void main(String[]args)
	{
		long timeStampBefore=System.currentTimeMillis();
		boolean check = false;
		for(int i=0; i<2147483647;i+=20)
		{
			//System.out.println(i);
			if(i==0)
				continue;
			else if(isPrime(i))
				continue;
			else
			{
				for(int a=19;a>10;a--)
				{
					if(i%a!=0)
					{
						check=false;
						break;
					}
					else
						check=true;

				}

				if(check)
				{
					System.out.print(i);
					break;
				}
			}
			
		}

		long timeStampAfter=System.currentTimeMillis();
		long timeTaken=timeStampAfter-timeStampBefore;
		System.out.println("Took " + timeTaken+"ms to run");
	}
}
