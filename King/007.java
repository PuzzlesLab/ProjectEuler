public class euler {
	
	public static int [] f=new int [100000];
	
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
		int count=2;
		for (long i=5;true;i+=2) {
			if (isPrimeNumber(i)) {
				count++;
				if (count==10001) {
					System.out.println(i);
					break;
				}
			}
		}
	}
}