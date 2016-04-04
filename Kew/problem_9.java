public class problem_9
{
	public static void main(String[]args)
	{
		long before=System.currentTimeMillis();
		boolean check=false;
		//for(int c=1000;c>25;c--)
		//{
			for(int b=1000;b>0;b--)
			{
				for(int a=b;a>0;a--)
				{
					int c=(int)Math.sqrt(b*b+a*a);
					if(c==(b*b+a*a))
					{
						if((a+b+c)==1000)
						{
							
							System.out.println(a*b*c);
							check=true;
							if(check)
								break;
						}
						if(check)
							break;
						//System.out.println(a+" "+b+" "+c);
					}
					if(check)
						break;
				}
				if(check)
					break;
			}
		//}

		long after=System.currentTimeMillis();
		System.out.println("Time taken:"+(after-before)+"ms");
	}
}