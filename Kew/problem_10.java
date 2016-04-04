public class problem_10
{
	public static boolean isPrime(long n)
	{

		if(n==1)
			return false;
		else if(n==2)
		{
			return true;
		}
		else
		{
			for(int i=3;i<=Math.sqrt(n);i+=2)
			{
				if(n%i==0)
					return false;
			}

			return true;
		}
	}

	public static void main(String[]args)
	{
		long before=System.currentTimeMillis();
		long sum=2;
		//System.out.print(sum+"\n");
		for(int i=3;i<=2000000;i+=2)
		{
			if(isPrime(i))
			{
				//System.out.println(i);
				sum+=i;
			}
		}

		System.out.println(sum);
		long after=System.currentTimeMillis();
		System.out.println("Time taken:"+(after-before)+"ms");
	}
}