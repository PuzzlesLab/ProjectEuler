import java.math.BigInteger;
public class problem_20
{
	public static void main(String[]args)
	{		
		long before=System.currentTimeMillis();
		BigInteger total=new BigInteger("1");
		//System.out.println(total);
		for(int i=100;i>0;i--)
		{
			BigInteger a=new BigInteger(Integer.toString(i));
			total=total.multiply(a);			
		}

		int ans=0;

		//System.out.println(total.toString());

		String temp=total.toString();

		for(int i=0;i<temp.length();i++)
		{
			ans+=Character.getNumericValue(temp.charAt(i));
		}

		System.out.println(ans);
		long after=System.currentTimeMillis();
		System.out.println("Time Taken = "+(after-before)+"ms");



		
	}
}