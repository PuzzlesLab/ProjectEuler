public class euler {
	
	public static int [] primeNumbers=new int [5000];
	public static int primeNumbersCount=0;
	public static boolean [] notPrime=new boolean [10001];
	
	public static void sieveOfEratosthenes () {
		for (int i=2;i*i<=10000;i++) {
			if (!notPrime[i]) {
				for (int i2=i*i;i2<=10000;i2+=i) {
					notPrime[i2]=true;
				}
			}
		}
		for (int i=1001;i<=10000;i++) {
			if (!notPrime[i]) {
				primeNumbers[primeNumbersCount++]=i;
			}
		}
	}
	
	public static int [][] groupedPrimeNumbers;
	public static int primeNumbersGroupCount=0;
	public static int [] primeNumbersInGroup;
	
	public static void groupPrimeNumbers() {
		boolean [] grouped=new boolean [primeNumbersCount];
		groupedPrimeNumbers=new int [1000][20];
		int [][] digitsOccurance=new int [primeNumbersCount][10];
		for (int i=0;i<primeNumbersCount;i++) {
			int toTest=primeNumbers[i];
			while (toTest>0) {
				digitsOccurance[i][toTest%10]++;
				toTest/=10;
			}
		}
		primeNumbersInGroup=new int [1000];
		for (int i=0;i<primeNumbersCount;i++) {
			if (!grouped[i]) {
				groupedPrimeNumbers[primeNumbersGroupCount][primeNumbersInGroup[primeNumbersGroupCount]++]=primeNumbers[i];
				for (int i2=i+1;i2<primeNumbersCount;i2++) {
					if (!grouped[i2]) {
						boolean match=true;
						for (int i3=0;i3<10;i3++) {
							if (digitsOccurance[i][i3]!=digitsOccurance[i2][i3]) {
								match=false;
								break;
							}
						}
						if (match) {
							groupedPrimeNumbers[primeNumbersGroupCount][primeNumbersInGroup[primeNumbersGroupCount]++]=primeNumbers[i2];
							grouped[i2]=true;
						}
					}
				}
				grouped[i]=true;
				primeNumbersGroupCount++;
			}
		}
	}
	
	public static String validateProperty(int [] primes, int max) {
		for (int i=0;i<max;i++) {
			for (int i2=i+1;i2<max;i2++) {
				int diff=primes[i2]-primes[i];
				int expectedNextValue=primes[i2]+diff;
				for (int i3=i2+1;i3<max;i3++) {
					if (primes[i3]==expectedNextValue) {
						return primes[i]+""+primes[i2]+""+primes[i3];
					}
				}
			}
		}
		return null;
	}
	
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		sieveOfEratosthenes();
		groupPrimeNumbers();
		String answer="";
		for (int i=0;i<primeNumbersGroupCount;i++) {
			String s=validateProperty(groupedPrimeNumbers[i],primeNumbersInGroup[i]);
			if (s!=null && !s.equals("148748178147")) {
				answer=s;
			}
		}
		System.out.println(answer);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
} 