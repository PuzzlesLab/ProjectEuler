public class problem_12
{
	public static int numberOfDivisor(int n)
	{
		int nod=0;
		int sqrt=(int)Math.sqrt(n);

		for(int i=1;i<=sqrt;i++)
		{
			if(n%i==0)
				nod+=2;
		}

		if(sqrt*sqrt==n)
			nod--;

		return nod;
	}
	public static void main(String[]args)
	{
		long before=System.currentTimeMillis();
		int i=0;
		int number=0;
		while(numberOfDivisor(number)<=500)
		{
			i++;
			number+=i;
		}

		System.out.println(number);
		long after=System.currentTimeMillis();
		System.out.println("Time Taken: "+(after-before)+"ms");
	}
}