public class Euler {
	
	private static int MaxPow=14;
	private static boolean [] notPrime=new boolean [(int)Math.pow(10, MaxPow/2)];
	private static long [] primeNumbers=new long [notPrime.length/2];
	private static int primeNumbersCount=0;
	
	private static void sieveOfEratothenes() {
		for (int i=2;i*i<notPrime.length;i++) {
			if (!notPrime[i]) {
				for (int i2=i*i;i2<notPrime.length;i2+=i) {
					notPrime[i2]=true;
				}
			}
		}
		notPrime[0]=true;
		notPrime[1]=true;
		
		for (int i=2;i<notPrime.length;i++) {
			if (!notPrime[i]) {
				primeNumbers[primeNumbersCount++]=i;
			}
		}
	}
	
	private static boolean isPrime (long l) {
		if (l<notPrime.length) {
			return !notPrime[(int) l];
		} else {
			for (int i=0;primeNumbers[i]*primeNumbers[i]<=l;i++) {
				if (l%primeNumbers[i]==0) {
					return false;
				}
			}
			return true;
		}
	}
	
	private static long [] strongHarshardNumbers=new long [100000];
	private static int strongHarshardNumbersCount=0;
	
	private static void generateStrongHarshadNumbers (long num, int digitsSum , int digitsCount) {
		if (digitsCount<MaxPow) { //Generate until 10^13.
			for (int i=0;i<10;i++) {
				long currNum=num*10+i;
				int currDigitsSum=digitsSum+i;
				if (currNum!=0 && currNum%currDigitsSum==0) {
					if (isPrime(currNum/currDigitsSum)) {
						strongHarshardNumbers[strongHarshardNumbersCount++]=currNum;
					}
					generateStrongHarshadNumbers(currNum,currDigitsSum,digitsCount+1);
				}
			}
		}
	}
	
	private static long answer=0;
	
	private static void findHarshardPrimes () {
		//Form prime from strong harshad numbers.
		for (int i=0;i<strongHarshardNumbersCount;i++) {
			for (int i2=1;i2<10;i2+=2) {
				long prime=strongHarshardNumbers[i]*10+i2;
				if (isPrime(prime)) {
					answer+=prime;
				}
			}
		}
	}
	
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		sieveOfEratothenes();
		generateStrongHarshadNumbers(0,0,1);
		findHarshardPrimes();
		System.out.println(answer);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
} 