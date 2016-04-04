public class problem_6
{
	public static void main(String[]args)
	{
		long before=System.currentTimeMillis();
		int sumOfSquare=0;
		int difference=0;
		int squareOfSum=0;
		for(int i=1;i<101;i++)
		{
			sumOfSquare=sumOfSquare+i*i;
		}

		for(int i=1;i<101;i++)
		{
			squareOfSum+=i ;
		}

		//System.out.println(sumOfSquare);
		//System.out.println(squareOfSum);
		squareOfSum*=squareOfSum;
		difference=squareOfSum-sumOfSquare;

		System.out.println(difference);

		long after=System.currentTimeMillis();
		long timeTaken=after-before;
		System.out.println("Time taken:" + timeTaken);

	}
}