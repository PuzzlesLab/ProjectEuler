import java.math.BigInteger;
public class problem_25
{
	public static void main(String[]args)
	{
		long before=System.currentTimeMillis();
		//int temp1=1;
		//int temp2=2;	
		int index=0;	

		BigInteger temp1=new BigInteger("1");
		BigInteger temp2=new BigInteger("2");


		//while(numDigit(temp2)!=100)
		while(numDigit(temp2)!=1000)
		{
			//int temp=temp2;
			BigInteger temp=new BigInteger(temp2.toString());
			temp2=temp2.add(temp1);
			temp1=temp;

			//temp2=temp2+temp1;
			//temp1=temp;
			index++;			
		}

		System.out.println(index+3);
		long after=System.currentTimeMillis();
		System.out.println("Time taken="+(after-before)+"ms");
	}	

	public static int numDigit(BigInteger n)
	{
		return((n.toString()).length());
	}
}