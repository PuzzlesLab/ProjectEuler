public class Main {

	public static int [] primeNumbers=new int [500000];
	public static int primeNumbersCount=0;
	public static boolean [] notPrime=new boolean [1000001];
	
	public static void sieveOfEratosthenes () {
		for (int i=2;i*i<notPrime.length;i++) if (!notPrime[i])
			for (int i2=i*i;i2<notPrime.length;i2+=i) notPrime[i2]=true;
		
		for (int i=2;i<notPrime.length;i++) if (!notPrime[i]) primeNumbers[primeNumbersCount++]=i;
	}
	
	public static int totient (int n) {
		if (n==1) return 1;
		else if (!notPrime[n]) return n-1;
		else {
			double value=n;
			for (int i=0;primeNumbers[i]*primeNumbers[i]<=n;i++) {
				if (n%primeNumbers[i]==0) {
					while (n%primeNumbers[i]==0) {
						n/=primeNumbers[i];
					}
					value*=(1-1.0/primeNumbers[i]);
				}
			}
			if (n>1) value*=(1-1.0/n);
			return (int)value;
		}
	}
	
	public static void main (String [] abc) {
		long startTime=System.currentTimeMillis();
		sieveOfEratosthenes();
		long answer=0;
		for (int i=2;i<=1000000;i++) answer+=totient(i);
		long endTime=System.currentTimeMillis();
		System.out.println(answer);
		System.out.println("Took "+(endTime-startTime)+"ms.");
	}
}