public class problem_19
{
	public static void main(String[]args)
	{
		long before=System.currentTimeMillis();
		int day=1;
		int[]month={1,2,3,4,5,6,7,8,9,10,11,12};
		int[]normalDay={31,28,31,30,31,30,31,31,30,31,30,31};
		int[]leapDay={31,29,31,30,31,30,31,31,30,31,30,31};
		//int[]specialDay={28,29};
		//int[]monthDay={30,31};
		int count=0;
		int index=2;

		int year=1901;
		while(true)
		{
			if(year%4==0)
			{
				for(int i=0;i<12;i++)
				{
					for(int j=1;j<=leapDay[i];j++)
					{											
						//System.out.println("day = "+j);						
						if(index==7)
							index=0;
						index++;
						if(year==2000&&i==11&&j==31)
						{
							System.out.println(count);
							long after=System.currentTimeMillis();
							System.out.println("Time taken:"+(after-before)+"ms");
							System.exit(1);
						}
						//System.out.println("index = "+index);
					}
					if(index==7)
						count++;
				}
				year++;
			}
			else
			{
				for(int i=0;i<12;i++)
				{
					for(int j=1;j<normalDay[i];j++)
					{				
						//System.out.println("day = "+day);			
						if(index==7)
							index=0;
						index++;
						if(year==2000&&i==11&&j==31)
						{
							System.out.println(count);
							long after=System.currentTimeMillis();
							System.out.println("Time taken:"+(after-before)+"ms");
							System.exit(1);
						}
						//System.out.println("index = "+index);						
					}
					if(index==7)
						count++;
				}
				year++;
			}
			//System.out.println("year = "+year);

			if(year==1901)
				break;
		}

		System.out.println(count);
		
	}
}