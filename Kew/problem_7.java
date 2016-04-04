public class problem_7
{
	public static boolean isPrime(int n)
	{
			for(int i=3;i<=Math.sqrt(n);i+=2)
			{
				if(n%i==0)
					return false;
			}

			return true;
	}
	public static void main(String[]args)
	{
		long before=System.currentTimeMillis();
		int count=1;
		int countUser=15;
		for(int i=3;i<=2147483647;i+=2)
		{
			if(isPrime(i))
			{
				//System.out.println(i);
				count++;
				//System.out.print("count =" + count);
			}

			if(count==countUser)
			{
				System.out.println(i);
				break;
			}
		}

		long after=System.currentTimeMillis();
		long timeTaken=after-before;
		System.out.println("Time taken:" +timeTaken);
	}
}