public class euler {
	
	public static void main (String [] abc) {
		long before=System.currentTimeMillis();
		
		//Sieve of Eratosthenes
		boolean [] notPrime=new boolean [500000];
		for (int i=2;i*i<notPrime.length;i++) {
			if (!notPrime[i]) {
				for (int i2=i*i;i2<notPrime.length;i2+=i) {
					notPrime[i2]=true;
				}
			}
		}
		
		int count=0;
		int value=0;
		for (int i=2;i<notPrime.length;i++) {
			if (!notPrime[i]) {
				count++;
				if (count==10001) {
					value=i;
					break;
				}
			}
		}
		long after=System.currentTimeMillis();
		long timeTaken=after-before;
		System.out.println(value);
		System.out.println("Time taken: " +timeTaken+" ms");
	}
}