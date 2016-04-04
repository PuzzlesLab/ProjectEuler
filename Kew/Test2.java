public class Test2
{
	public static void main(String[]args)
	{
		//for(int i=2;i<11;i++)
		//{
		int i=7;
		double ans=1.0/(double)i;
		String[]decimal=(Double.toString(ans).split("\\."));
		String temp="";
		System.out.println(decimal[1]);
		System.out.println(checkRepeat(decimal[1]));


		for(int j=0;j<decimal[1].length();j++)
		{
			temp+=Character.toString(decimal[1].charAt(j));
			if(temp.charAt(0)==decimal[1].charAt(j))
			{
				for(int k=0;k<j&&(j+k<decimal[1].length());k++)
				{	
					System.out.println("temp.charAt="+temp.charAt(k));
					System.out.println("decimal.charAt="+decimal[1].charAt(j+k));
					if(temp.charAt(k)!=decimal[1].charAt(j+k))
					{																
						break;
					}
				}	
			}

						
		}

		//}
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