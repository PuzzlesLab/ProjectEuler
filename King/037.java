public class euler {
	
	public static int [] primeNumbers=new int [800001]; //11th value = 739397
	public static int primeNumbersCount=0;
	
	public static void sieveOfEratosthenes () {
		boolean [] flag=new boolean [primeNumbers.length];
		for (int i=2;i*i<=primeNumbers.length-1;i++) {
			if (!flag[i]) {
				for (int i2=i*i;i2<=primeNumbers.length-1;i2+=i) {
					flag[i2]=true;
				}
			}
		}
		for (int i=2;i<primeNumbers.length;i++) {
			if (!flag[i]) {
				primeNumbers[primeNumbersCount++]=i;
			}
		}
	}
	
	public static boolean isPrime (int num) {
		int min=0,mid,max=primeNumbersCount-1;
		while (min<=max) {
			mid=(min+max)/2;
			if (primeNumbers[mid]==num) {
				return true;
			} else if (primeNumbers[mid]>num) {
				max=mid-1;
			} else {
				min=mid+1;
			}
		}
		return false;
	}
	
	public static boolean truncatablePrime (int toTest) {
		int num=toTest;
		if (num%2==0 || !isPrime(toTest)) {
			return false;
		}
		// Remove left and test.
		for (int i=(int)Math.log10(num);i>0;i--) {
			num%=(int)(Math.pow(10,i));
			if (!isPrime(num)) {
				return false;
			}
		}
		// Remove right and test.
		num=toTest/10;
		while (num>0) {
			if (!isPrime(num)) {
				return false;
			}
			num/=10;
		}
		return true;
	}
	
	public static void main (String [] abc) {
		long start=System.currentTimeMillis();
		sieveOfEratosthenes();
		int count=0, sum=0, test=23;
		while (count<11) {
			if (truncatablePrime(test)) {
				count++;
				sum+=test;
			}
			test++;
		}
		System.out.println(sum);
		System.out.println("Took "+(System.currentTimeMillis()-start)+"ms.");
	}
}