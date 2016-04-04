public class problem_14
{
	public static long calculation(long n)
	{
		if(n%2==0)
		{
			return (n/2);
		}
		else
			return (3*n+1);
	}

	public static int maxValue(int n,int max)
	{
		
		if(n>max)
		{
		
			return n;
		}
		else
			return max;
	}


	public static void main(String[]args)
	{
		long before=System.currentTimeMillis();
		long i=0;
		long temp=0;
		int count=2;
		int max=0;
		while(i<=1000000)
		{
			i++;
			temp=i;
			//System.out.println("i = "+i);
			while(calculation(i)>1)
			{
				
				//System.out.println(calculation(i));
				i=calculation(i);
				count++;
			}
			//System.out.println("count "+count);
			//System.out.println("");
			max=maxValue(count,max);
			if(count==525)
			{
				System.out.println(temp);
				break;
			}
			count=2;
			i=temp;
		}
		System.out.println(max);
		long after=System.currentTimeMillis();
		System.out.println("Time Taken:"+(after-before)+"ms");
	}
}