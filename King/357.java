public class euler {
	
	private static int MaxNumber=100000002;
	private static boolean [] NotPrime = new boolean [MaxNumber];
	private static int [] PrimeNumbers=new int [MaxNumber];
	private static int PrimeNumbersCount=0;
	
	private static void sieveOfEratothenes() {
		for (int i=2;i*i<MaxNumber;i++) {
			if (!NotPrime[i]) {
				for (int i2=i*i;i2<MaxNumber;i2+=i) {
					NotPrime[i2]=true;
				}
			}
		}
		for (int i=2;i<MaxNumber;i++) {
			if (!NotPrime[i]) {
				PrimeNumbers[PrimeNumbersCount++]=i;
			}
		}
	}
	
	public static boolean validate (int num) {
		boolean flag=!NotPrime[1+num];
		if (NotPrime[num]) { //Only search for non prime numbers.
			for (int i=2;i*i<=num && flag;i+=1) {
				if (num%i==0) {
					flag = flag && (!NotPrime[i+num/i]);
					//getting a number is enough as putting the divisor pair into the formula will give same result.
				}
			}
		}
		return flag;
	}
	
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		sieveOfEratothenes();
		long sum=0;
		for (int i=1;i<=100000000;i++) {
			if (validate(i)) {
				sum+=i;
			}
		}
		System.out.println(sum);
		long after=System.currentTimeMillis();
		System.out.println("Took "+(after-before)+" ms.");
	}
	
}
