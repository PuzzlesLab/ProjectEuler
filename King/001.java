public class euler {
	
	public static int sumOfMultiplesLimit (int num, int limit) {
		int n=(limit-1)/num;
		return (n*(2*num+(n-1)*num))/2;
	}
	
	public static void main (String [] zzzz) {
		long before=System.currentTimeMillis();
		int limit=1000;
		System.out.println(sumOfMultiplesLimit(3,limit)+sumOfMultiplesLimit(5,limit)-sumOfMultiplesLimit(15,limit));
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}