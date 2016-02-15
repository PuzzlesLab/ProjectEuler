public class euler {
	
	public static boolean isPrimeNumber (int l) {
		if (l%2==0 || l%3==0) {
			return false;
		}
		int limit=(int)(Math.sqrt(l))+1;
		for (int check=3;check<limit;check+=2) { //(l+1) to prevent precision error happened to prefect squares.
			if (l%check==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main (String [] abc) {
		long before=System.currentTimeMillis();
		int count=2;
		for (int i=5;true;i+=2) {
			if (isPrimeNumber(i)) {
				count++;
				if (count==10001) {
					System.out.println(i);
					break;
				}
			}
		}
		long after=System.currentTimeMillis();
		long timeTaken=after-before;
		System.out.println("Time taken:" +timeTaken);
	}
}