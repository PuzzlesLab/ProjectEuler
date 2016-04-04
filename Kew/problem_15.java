public class problem_15
{
	public static void main(String[]args)
	{
		int x=20;
		int y=20;

		long[][]ans=new long[x][y];

		for(int i=0;i<x;i++)
		{
			ans[0][i]=2+i;
			ans[i][0]=2+i;
		}

		for(int i=1;i<x;i++)
		{
			for(int j=1;j<x;j++)
			{
				ans[j][i]=ans[j-1][i]+ans[j][i-1];
			}
		}

		for(int i=1;i<x;i++)
		{
			System.out.println("ans"+"["+i+"]"+"["+(i-1)+"] = "+ans[i][i-1]);
			System.out.println("ans"+"["+(i-1)+"]"+"["+(i)+"] = "+ans[i-1][i]);
			System.out.println("ans"+"["+i+"]"+"["+i+"] = " +ans[i][i]);
		}
	}

	
}

