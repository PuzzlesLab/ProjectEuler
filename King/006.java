public class euler {

	public static void main (String [] zzz) {
		int n=100;
		int sumSquare = (n*(n+1)/2);
		sumSquare*=sumSquare;
		int squareSum = (n*(n+1)*(2*n+1))/6;
		System.out.println(sumSquare-squareSum);
	}
}