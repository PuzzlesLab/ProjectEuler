public class euler {
	
	public static int [] primeNumbers=new int [800001]; //11th value = 739397
	public static int primeNumbersCount=0;
	public static boolean [] notPrime=new boolean [800001];
	public static int [] leftTruncatable=new int [1000001]; //0 = not yet tested, 1=tested, true, 2=tested, false.
	public static int [] rightTruncatable=new int [1000001]; //0 = not yet tested, 1=tested, true, 2=tested, false.

	
	public static void sieveOfEratosthenes () {
		for (int i=2;i*i<=primeNumbers.length-1;i++) {
			if (!notPrime[i]) {
				for (int i2=i*i;i2<=primeNumbers.length-1;i2+=i) {
					notPrime[i2]=true;
				}
			}
		}
		notPrime[0]=true;
		notPrime[1]=true;
		primeNumbers[primeNumbersCount++]=2;
		for (int i=3;i<primeNumbers.length;i+=2) {
			if (!notPrime[i]) {
				primeNumbers[primeNumbersCount++]=i;
			}
		}
	}
	
	public static boolean isPrime (int num) {
		return !notPrime[num];
	}
	
	public static boolean testLeftTruncatable (int toTest) {
		if (leftTruncatable[toTest]==0) {
			if (toTest<10) {
				if (isPrime(toTest)) {
					leftTruncatable[toTest]=1;
				} else {
					leftTruncatable[toTest]=2;
				}
			} else {
				int divisor=(int)Math.pow(10,(int)Math.log10(toTest));
				if (isPrime(toTest) && testLeftTruncatable(toTest-(toTest/divisor)*divisor)) {
					leftTruncatable[toTest]=1;
				} else {
					leftTruncatable[toTest]=2;
				}
			}
		}
		return leftTruncatable[toTest]==1;
	}

	public static boolean testRightTruncatable (int toTest) {
		if (rightTruncatable[toTest]==0) {
			if (toTest<10) {
				if (isPrime(toTest)) {
					rightTruncatable[toTest]=1;
				} else {
					rightTruncatable[toTest]=2;
				}
			} else {
				if (isPrime(toTest) && testRightTruncatable(toTest/10)) {
					rightTruncatable[toTest]=1;
				} else {
					rightTruncatable[toTest]=2;
				}
			}
		}
		return rightTruncatable[toTest]==1;
	}
	
	public static boolean truncatablePrime (int toTest) {
		return isPrime(toTest) && testLeftTruncatable(toTest) && testRightTruncatable(toTest);
	}
	
	public static void main (String [] abc) {
		long start=System.currentTimeMillis();
		sieveOfEratosthenes();
		int count=0, sum=0;
		//2,3,5,7,11,13, start with 13.
		for (int i=5;i<primeNumbersCount && count<11;i++) {
			if (truncatablePrime(primeNumbers[i])) {
				count++;
				sum=sum+primeNumbers[i];
			}
		}
		System.out.println(sum);
		System.out.println("Took "+(System.currentTimeMillis()-start)+"ms.");
	}
}