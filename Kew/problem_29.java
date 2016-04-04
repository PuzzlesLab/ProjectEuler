public class problem_29
{
	public static void main(String[]args)
	{
		int limit=100;
		boolean[] repeat=new boolean[101];
		int ans=99*99;
		System.out.println(ans);
		for(int i=limit;i>=2;i--)
		{
			for(int j=2;j<10;j++)
			{
				if(Math.pow(i,j)>limit)
					break;		
				if(repeat[(int)Math.pow(i,j)]==true)
					continue;
				else
					repeat[(int)Math.pow(i,j)]=true;					
				System.out.println(Math.pow(i,j));
				int reminder=limit/j-1;
				System.out.println("reminder="+reminder);
				ans-=reminder;				
				System.out.println("ans="+ans);
			}
		}
		

		System.out.println(ans);
	}
}