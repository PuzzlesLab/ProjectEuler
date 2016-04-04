import java.util.ArrayList;
public class problem_29_v2
{
	public static void main(String[]args)
	{
		ArrayList<Double>num=new ArrayList<>();
		long before=System.currentTimeMillis();
		for(int i=2;i<101;i++)
		{
			for(int j=2;j<101;j++)
			{
				if(!num.contains(Math.pow(i,j)))
					num.add(Math.pow(i,j));
			}
		}

		System.out.println(num.size());
		long after=System.currentTimeMillis();
		System.out.println("Time Taken = "+(after-before)+"ms");
	}
}