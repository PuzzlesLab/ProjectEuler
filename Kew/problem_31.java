public class problem_31
{
	public static void main(String[]args)
	{
		int money=50;
		int one=0;
		int two=0;
		int five=0;
		int ten=0;
		int twety=0;
		int fifty=0;
		int hundred=0;
		int twoHundred=0;
		int count=0;
		int sum=0;
		int temp=0;

		for(int a=0;a<=money;a+=200)
		{
			sum=0;			
			sum+=a;
			//System.out.println("count="+count);			
			if(sum==money)
			{
				count++;
				temp=sum;
				continue;
			}
			else if(sum>money)
			{
				break;
			}
			for(int b=0;b<=money;b+=100)
			{				
				sum=temp;
				sum+=b;
				if(sum==money)
				{
					count++;
					temp=sum;
					continue;
				}
				else if(sum>money)
				{
					break;
				}				
				for(int c=0;c<=money;c+=50)
				{			
					sum=temp;		
					sum+=c;
					if(sum==money)
					{											
						count++;
						temp=sum;
						continue;
					}		
					else if(sum>money)
					{
						break;
					}
					for(int d=0;d<=money;d+=20)
					{			
						sum=temp;		
						sum+=d;

						for(int e=0;e<=money;e+=10)
						{							
							sum+=e;
							if(sum==money)
							{		
								temp=sum;									
								count++;
								continue;
							}		
							else if(sum>money)
							{
								break;
							}

							for(int f=0;f<=money;f+=5)
							{		
								sum=temp;						
								sum+=f;
								if(sum==money)
								{		
									temp=sum;									
									count++;
									continue;
								}		
								else if(sum>money)
								{
									break;
								}

								for(int g=0;g<=money;g+=2)
								{			
									sum=temp;						
									sum+=g;
									if(sum==money)
									{	
										temp=sum;										
										count++;
										continue;
									}		
									else if(sum>money)
									{
										break;
									}	

									for(int h=0;h<=money;h++)
									{			
										sum=temp;							
										sum+=h;
										System.out.println("count="+count);
										System.out.println("sum="+sum);
										if(sum==money)
										{	
											temp=sum;										
											count++;
											continue;
										}		
										else if(sum>money)
										{
											break;
										}								
									}
								}
							}
						}
					}
				}
			}

			System.out.println(count);
		}
	}

	public static boolean checkValue(int sum)
	{
		if(sum>=200)
			return true;
		else
			return false;
	}
}