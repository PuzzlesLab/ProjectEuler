public class problem_26_v2
{
	public static void main(String[]args)
	{
		int max=0;
		int maxI=0;

		for(int i=983;i<984;i++)
		{
			int a=10;
			int index=0;
			String decimal="";			
			boolean check=false;

			while(index!=1500&&a!=0)
			{
				decimal+=Integer.toString(a/i);
				a%=i;
				a*=10;
				index++;				
			}
			int count=0;

			System.out.println("i="+i);
			System.out.println("decimal="+decimal);
			if(!(checkRepeat(decimal)))
			{
				decimal+="0";
				for(int j=1;j<decimal.length();j++)
				{
					if(checkLast(decimal,j))
						break;
					check=false;
					count++;

					if(decimal.charAt(j-1)!=decimal.charAt(j))
					{
						for(int k=0;k<j&&(j+j)<decimal.length();k++)
						{														
							String temp=decimal.substring(k,j);
							String temp2=decimal.substring(j,j+j-k);
							//String temp2=decimal.substring(j,10);
							//System.out.println("temp="+temp);
							//System.out.println("temp2="+temp2);
							if(temp.equals(temp2))
							{
								check=true;
								break;
							}
						}

						if(check)
							break;
					}
				}
			}

			if(count>max)
			{
				max=count;
				maxI=i;
			}
		}

		System.out.println("max="+max);
		System.out.println("d="+maxI);

	}

	public static boolean checkLast(String n, int position)
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