package euler;

public class euler {
	
	/*
	 * 
	 * 		n
	 * --------------
	 *    phi (n)
	 * 
	 * To maximize the value, n needs to be maximized.
	 * phi (n) needs to be minimized.
	 * 
	 * the number of relatively prime number should be as low
	 * as possible.
	 * 
	 * Prime numbers has most phi (n), so by multiplying them,
	 * We can now get the least phi(n)...
	 * 
	 * 2 x 3 = 6... so multiplier for 2 and 3 are now gone, left only 1 and 5
	 * 2 x 3 x 5 = 30... so all multiplers for 2, 3 and 5 are now gone, left only 1, and prime numbers below 30 excluding 2,3, and 5..
	 * 
	 */
	
	public static boolean [] notPrime=new boolean [1000000];
	public static int [] primeNumbers=new int [500000];
	public static int primeNumbersCount=0;
	
	public static void sieveOfEratothenes () {
		for (int i=2;i*i<=1000000;i++) {
			if (!notPrime[i]) {
				for (int i2=i*i;i2<1000000;i2+=i) {
					notPrime[i2]=true;
				}
			}
		}
		for (int i=2;i<1000000;i++) {
			if (!notPrime[i]) {
				primeNumbers[primeNumbersCount++]=i;
			}
		}
	}
	
	public static void main (String [] zzzz) throws Exception {
		sieveOfEratothenes();
		int n=1;
		int p=0;
		while (n<1000000) {
			n*=primeNumbers[p++];
		}
		//n > 1000000 now.
		System.out.println(n/primeNumbers[p-1]);
	}
}