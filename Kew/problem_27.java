public class problem_27
{
	public static void main(String[]args)
	{
		long before=System.currentTimeMillis();
		int n=0;		
		int ans=0;
		int max=0;
		int maxX=0;
		int maxY=0;
		int x=0;
		int y=0;
		boolean check=false;
		for(int a=-1000;a<1000;a++)
		{
			check=false;
			n=0;			
			for(int b=-1000;b<1000;b++)
			{	
				if(!isPrime(b))
					continue;
				if(Math.abs(a)%2==0&&Math.abs(b)%2!=0)
					continue;
				if(Math.abs(a)%2==0&&Math.abs(b)%2!=0)
					continue;	
				//System.out.println(b);
				n=0;		
				//System.out.println("a="+a);
				//System.out.println("b="+b);
				while(true)
				{
					ans=n*n+a*n+b;	
					//System.out.println(ans);				
					if(!isPrime(ans))
					{
						x=a;
						y=b;
						check=true;
						break;
					}			
					n++;			
				}


				if(n>max)
				{
					maxX=x;
					maxY=y;
					max=n;	
				}					
				if(check)
					continue;
			}	
		}

		System.out.println("max="+max);
		System.out.println("a="+maxX);
		System.out.println("b="+maxY);

		System.out.println("ans="+maxX*maxY);
		long after=System.currentTimeMillis();
		System.out.println("Time Taken = "+(after-before)+"ms");
	}

	public static boolean isPrime(int n)
	{
		if(n==1)			
			return false;
		else if(n<0)
			return false;
		else if(n==2)
			return true;
		else 
		{
			for(int i=2;i<=Math.sqrt(n);i++)
			{
				if(n%i==0)
					return false;				
			}
			return true;
		}
	}
}