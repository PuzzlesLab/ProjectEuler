public class problem_21
{
	public static void main(String[]args)
	{
		
		int sum1=0;
		int sum2=0;
		int index=10;
		int ans=0;

		while(index<=10000)
		{
			for(int i=1;i<index;i++)
			{
				if(index%i==0)
					sum1+=i;			
			}

			for(int i=1;i<sum1;i++)
			{
				if(sum1%i==0)
					sum2+=i;
			}

			if(sum1==sum2)
			{
				sum1=0;
				sum2=0;
				index++;
				continue;
			}
				

			if(index==sum2)
			{
				System.out.println(index);
				ans+=index;							
			}
				
			sum1=0;
			sum2=0;

			index++;
		}

		System.out.println(ans);
	}
}