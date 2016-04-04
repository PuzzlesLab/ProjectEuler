import java.math.BigInteger;
public class problem_16
{
	public static void main(String[]args)
	{
		BigInteger a=new BigInteger("2");

		//System.out.println(a.pow(1000));

		String b=String.valueOf(a.pow(1000));

		System.out.println(b);

		long total=0;

		for(int i=0;i<b.length();i++)
		{
			System.out.println(b.charAt(i));
			total+=b.charAt(i)-48;
			System.out.println("total="+total);
		}

		System.out.println(total);


	}
}