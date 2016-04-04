public class problem_28
{
	public static void main(String[]args)
	{
		long before=System.currentTimeMillis();
		int index=2;
		int sum=1;
		int ans=1;
		while(sum<1002001)
		{
			for(int i=0;i<4;i++)
			{				
				sum+=index;				
				ans+=sum;
			}					
			index+=2;
		}

		System.out.println(ans);
		long after=System.currentTimeMillis();
		System.out.println("Time Taken : "+(after-before)+"ms");
	}
}