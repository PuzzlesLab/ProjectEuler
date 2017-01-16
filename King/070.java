public class Main {

	public static int [] primeNumbers=new int [5000];
	public static int primeNumbersCount=0;
	public static boolean [] notPrime=new boolean [10000];
	
	public static void sieveOfEratosthenes () {
		for (int i=2;i*i<notPrime.length;i++) if (!notPrime[i])
			for (int i2=i*i;i2<notPrime.length;i2+=i) notPrime[i2]=true;
		
		for (int i=2;i<notPrime.length;i++) if (!notPrime[i]) primeNumbers[primeNumbersCount++]=i;
	}
	
	public static boolean isPermutation (int n1, int n2) {
		int [] flag=new int [10];
		while (n1>0) {
			flag[n1%10]++;
			n1/=10;
		}
		while (n2>0) {
			flag[n2%10]--;
			n2/=10;
		}
		for (int i=0;i<10;i++) if (flag[i]!=0) return false;
		return true;
	}
	
	public static void main (String [] abc) {
		/*
		 * To minimize the ratio, n must be minimized, totient(n) must be maximized.
		 * For prime numbers, totient(n) = n-1, which means the ratio will be lowest among other numbers, but totient(n) is not permutation of n.
		 * The next maximized number would be n = p x q, where p and q are primes, totient(n) = (p-1)(q-1).
		 */
		long startTime=System.currentTimeMillis();
		sieveOfEratosthenes();
		double minRatio=Double.MAX_VALUE;
		int answer=-1;
		for (int p=0;p<primeNumbersCount;p++) for (int q=p+1;q<primeNumbersCount && primeNumbers[p]*primeNumbers[q]<10000000;q++) {
			int n=primeNumbers[p]*primeNumbers[q];
			int totient=(primeNumbers[p]-1)*(primeNumbers[q]-1);
			double ratio=n/(double) totient;
			if (ratio<minRatio && isPermutation(n,totient)) {
				minRatio=ratio;
				answer=n;
			}
			
		}
		long endTime=System.currentTimeMillis();
		System.out.println(answer);
		System.out.println("Took "+(endTime-startTime)+"ms.");
	}
}