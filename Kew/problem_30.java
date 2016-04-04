public class problem_30
{
	public static void main(String[]args)
	{
		//int limit=Integer.MAX_VALUE;	
		long before=System.currentTimeMillis();
		int limit=1000000;	
		
		int sum=0;

		for(int i=2;i<limit;i++)
		{
			int sumDigit=0;
			int digit=0;
			int temp=i;
			//System.out.println("i="+i);
			String s=Integer.toString(i);
			for(int j=0;j<s.length();j++)
			{
				digit=Character.getNumericValue(s.charAt(j));
				sumDigit+=Math.pow(digit,5);				
				if(Math.pow(digit,5)>i)
					break;
			}		
			if(sumDigit==i)
			{
				System.out.println(i);
				sum+=sumDigit;
			}

			
		}	


		System.out.println(sum);
		long after=System.currentTimeMillis();
		System.out.println("Time Taken:"+(after-before)+"ms");
	}
}