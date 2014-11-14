public class euler {
	
	public static void main (String [] zzz) {
		int squareSum=0;
		for (int i=1;i<=100;i++) {
			squareSum=squareSum+i*i;
		}
		int sumSquare=5050*5050;
		System.out.println(sumSquare-squareSum);
	}
}