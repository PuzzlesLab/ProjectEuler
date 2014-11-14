public class euler {

	public static boolean isPrimeNumber (long l) {
		if (l%2==0 || l%3==0) {
			return false;
		}
		for (long check=3;check*check<(l+1);check+=2) { //(l+1) to prevent precision error happened to prefect squares.
			if (l%check==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main (String [] abc) {
		long sum=5; // 2 + 3;
		for (int i=5;i<2000000;i++) {
			if (isPrimeNumber(i)) {
				sum+=i;
			}
		}
		System.out.println(sum);
	}
}