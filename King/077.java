public class Main {

	public static int [] primeNumbers=new int [5000];
	public static int primeNumbersCount=0;
	public static boolean [] notPrime=new boolean [10001];
	
	public static void sieveOfEratosthenes () {
		for (int i=2;i*i<notPrime.length;i++) if (!notPrime[i])
			for (int i2=i*i;i2<notPrime.length;i2+=i) notPrime[i2]=true;
		
		notPrime[0]=true;notPrime[1]=true;
		for (int i=2;i<notPrime.length;i++) if (!notPrime[i]) primeNumbers[primeNumbersCount++]=i;
	}
	
	public static void main (String [] abc) {
		long startTime=System.currentTimeMillis();
		sieveOfEratosthenes();
		
		int [] ways=new int [10001];
		ways[0]=1;
		
		for (int i=0;i<primeNumbersCount && primeNumbers[i]<ways.length;i++) {
			for (int i2=primeNumbers[i];i2<ways.length;i2++) {
				ways[i2]+=ways[i2-primeNumbers[i]];
			}
		}

		int answer=-1;
	
		for (int i=0;i<ways.length;i++) {
			if (ways[i]>5000) {
				answer=i;
				break;
			}
		}
		
		long endTime=System.currentTimeMillis();
		System.out.println(answer);
		System.out.println("Took "+(endTime-startTime)+"ms.");
	}
}