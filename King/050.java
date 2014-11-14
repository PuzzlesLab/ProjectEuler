public class euler {
	
	public static int [] primeNumbers=new int [5000];
	public static int primeNumbersCount=0;
	public static boolean [] notPrime=new boolean [1000001];
	
	public static void sieveOfEratosthenes () {
		notPrime[0]=true;
		notPrime[1]=true;
		for (int i=2;i*i<=1000000;i++) {
			if (!notPrime[i]) {
				for (int i2=i*i;i2<=1000000;i2+=i) {
					notPrime[i2]=true;
				}
			}
		}
		for (int i=2;i<=5000;i++) {
			if (!notPrime[i]) {
				primeNumbers[primeNumbersCount++]=i;
			}
		}
	}

	public static void main (String [] args) {
		double before=System.currentTimeMillis();
		sieveOfEratosthenes();
		int max=0;
		int length=0;
		int [] sum=new int [10000];
		sum[0]=2;
		for (int i=1;i<primeNumbersCount;i++) {
			sum[i]=sum[i-1]+primeNumbers[i];
		}
		for (int i=0;i<primeNumbersCount;i++) {
			for (int i2=i;i2<primeNumbersCount;i2++) {
				//not necessary from 0 to n, could be 1 to n, 2 to n.....
				int result=sum[i2]-sum[i];
				if (result<1000000) {
					if (!notPrime[result] && result>max && (i2-i+1)>length) {
						max=result;
						length=(i2-i+1);
					}
				} else {
					break;
				}
			}
		}
		System.out.println(max);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}