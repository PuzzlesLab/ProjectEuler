public class problem_26_v3
{
	public static void main(String[]args)
	{
		long before=System.currentTimeMillis();
		int max=0;
		int maxIndex=0;
		boolean repeat=false;
		for(int i=2;i<1000;i++)
		{
			repeat=false;
			String decimal="";
			if(isPrime(i))
			{
				//System.out.println("i="+i);
				int a=10;
				int index=0;	
				while(a!=0&&index<=1000)
				{
					decimal+=Integer.toString(a/i);
					a%=i;
					a*=10;
					index++;
				}
			}			
			else
				continue;
			//System.out.println("decimal="+decimal);

			for(int k=0;k<decimal.length();k++)
			{
				int count=6;
				if(k+6>decimal.length())
					break;
				String sub=decimal.substring(k,k+6);
				//System.out.println(sub);
				for(int j=6;j<decimal.length();j++)
				{
					if(j+5>decimal.length())
						break;
					//System.out.println(decimal.substring(j,j+6));
					if(sub.equals(decimal.substring(j,j+6)))
					{
						repeat=true;
						break;
					}						
					count++;
				}

				if(count>max)
				{
					max=count;
					maxIndex=i;
				}

				if(true)
					break;				
			}
		}

		System.out.println("max length="+max);
		System.out.println("i = "+maxIndex);
		long after=System.currentTimeMillis();
		System.out.println("Time Taken : "+(after-before)+"ms");
	}

	public static boolean isPrime(int n)
	{
		if(n==1)
			return false;
		else if(n==2)
			return true;
		else
		{
			for(int i=2;i<n;i++)
			{
				if(n%i==0)
					return false;
			}
			return true;
		}

	}
}