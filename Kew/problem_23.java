import java.util.ArrayList;
import java.math.BigInteger;
public class problem_23
{
	public static void main(String[]args)
	{
		long before=System.currentTimeMillis();
		long ans=0;
		ArrayList<Integer> num=new ArrayList<>();
		ArrayList<Integer> sumA=new ArrayList<>();

		int sum=0;
		for(int i=1;i<=28123;i++)
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
		
		System.out.println(num.size());

		for(int i=0;i<num.size();i++)
		{
			for(int j=i;j<num.size();j++)
			{
				if(num.get(i)+num.get(j)<=28123)					
					sumA.add(num.get(i)+num.get(j));

				if(num.get(i)+num.get(j)>28123)
					break;
			}
			//System.out.println("size="+sumA.size());
		}

		System.out.println(sumA.size());

		int j=num.size()-4;
	

		for(int i=0;i<10;i++)
		{
			System.out.println(sumA.get(j-i));
		}

		/*for(int i=0;i<sumA.size();i++)
		{
			System.out.println(sumA.get(i));
			if(sumA.get(i)==36)
			{
				System.out.println("i="+i);
				break;
			}			
		}*/

		//System.out.println(sumA);


		/*int index=0;
		int position=0;
		int jump=num.size()-1;
		boolean check=false;
		for(int i=1;i<=1000;i++)
		{					
			for(int j=0;j<sumA.size();j++)
			{	
				//System.out.println("j="+j);			
				if(sumA.get(j)==i)
				{
					//System.out.println("sumA = "+sumA.get(j));
					//System.out.println(i);
					check=true;
					break;
				}
				jump--;
				//System.out.println("j = "+j);
				if(sumA.get(j)>i)
				{
					//System.out.println("i is "+i);
					//System.out.println("more than "+ sumA.get(j));					
					j+=jump;								
				}

				if(j>sumA.size())
					break;
				//System.out.println("sumA is "+sumA.get(j));
			}
			jump=num.size();
			if(!check)
			{
				System.out.print(i+" ");
				ans+=i;
			}				
			check=false;
		}

		//test2
		/*for(int i=1;i<1000;i++)
		{
			if(!sumA.contains(i))
			{
				System.out.print(i+" ");
				ans+=i;
			}
		}*/

		System.out.println(ans);
		long after=System.currentTimeMillis();
		System.out.println("Time Taken:"+(after-before)+"ms");
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

