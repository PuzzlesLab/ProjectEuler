public class problem_26
{
	public static void main(String[]args)
	{
		long before =System.currentTimeMillis();
		int max=0;
		int maxI=0;
		//int i=7;
		for(int i=2;i<1000;i++)
		{
			//System.out.println("i="+i);		
			int a=10;
			int index=0;
			int jump=0;
			String decimal="";
			String temp="";

			//get the number behind decimal point 
			while(index!=1000&&a!=0)
			{
				decimal+=Integer.toString(a/i);
				a%=i;
				a*=10;
				index++;				
			}

			int count=0;
			//System.out.println("decimal="+decimal);
			//System.out.println(decimal.charAt(0));

			temp+=decimal.charAt(0);			
			boolean check=false;						

			if(!(checkRepeat(decimal)))
			{
				decimal+="0";				
				for(int j=1;j<decimal.length();j++)
				{		
					if(checkLast(decimal,j))
						break;
					check=false;		
					count++;
					//System.out.println("count="+count);					
					//System.out.println("decimal(j-1) = "+decimal.charAt(j-1));
					//System.out.println("decimal(j) = "+decimal.charAt(j));
					if(decimal.charAt(j-1)!=decimal.charAt(j))
					{									
						for(int y=0;y<temp.length();y++)
						{
							check=true;
							for(int k=y;k<temp.length()&&(j+k-y<decimal.length()-1);k++)
							{								
								//System.out.println("temp.charAt="+temp.charAt(k));
								//System.out.println("decimal="+decimal.charAt(j+k-y));
								if(temp.charAt(k)!=decimal.charAt(j+k-y))
								{								
									check=false;
								}
							}
							if(check)
								break;	
						}		
						if(check)
							break;													
					}
					temp+=Character.toString(decimal.charAt(j));
				}		
				//System.out.println("temp="+temp);

				if(count>max)
				{
					max=count;
					maxI=i;
				}
				
				//System.out.println("i="+i);	
				//System.out.println("count="+count);
				//System.out.println("max="+max);

				//System.out.println("\n");
			}
		}

		System.out.println("max="+max);
		System.out.println("d="+maxI);
		long after= System.currentTimeMillis();
		System.out.println("Time Taken: "+(after-before)+"ms");
	}

	public static boolean checkLast(String n,int position)
	{
		boolean check=true;
		for(int i=position+1;i<n.length()-1;i++)
		{
			if(n.charAt(i-1)!=n.charAt(i))
			{
				check=false;
				break;
			}
		}
		return check;
	}


	public static boolean checkRepeat(String n)
	{
		boolean check=true;
		for(int i=1;i<n.length();i++)
		{
			if(n.charAt(i-1)!=n.charAt(i))
				check=false;
		}
		return check;
	}
}