import java.util.ArrayList;

public class problem_23_v2
{
	public static void main(String[]args)
	{
		long before=System.currentTimeMillis();
		ArrayList<Integer>num=new ArrayList<>();
		int ans=0;
		int sum=0;
		for(int i=0;i<=28123;i++)
		{
			if(isPrime(i))
				continue;
			for(int j=1;j<i;j++)
			{
				if(i%j==0)
					sum+=j;
			}
			if(sum>i)
				num.add(i);
			sum=0;
		}

		//System.out.println(num);

		int[]sumA=new int[12148814];

		for(int i=0;i<num.size();i++)
		{
			for(int j=i;j<num.size();j++)
			{
				if(num.get(i)+num.get(j)<=28123)
					sumA[num.get(i)+num.get(j)]=1;
				if(num.get(i)+num.get(j)>28123)
					break;
			}
		}

		for(int i=1;i<=28123;i++)
		{
			if(sumA[i]==0)
				sum+=i;
		}

		System.out.println(sum);
		long after=System.currentTimeMillis();
		System.out.println("Time taken: "+(after-before)+"ms");
	}

	public static boolean isPrime(int n)
	{
		if(n==1)
			return false;
		else if(n==2)
			return false;
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