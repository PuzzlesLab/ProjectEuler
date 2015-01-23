package euler;

public class euler {
	
	public static int MaxCache=20000;
	public static boolean [] notPrime=new boolean [MaxCache];
	public static int [] primeNumbers=new int[MaxCache];
	public static int primeNumbersCount=0;
	public static boolean [][] primePair=new boolean [10000][10000];
	
	public static void sieveOfEratosthenes () {
		notPrime[0]=true;
		notPrime[1]=true;
		for (int i=2;i*i<MaxCache;i++) {
			if (!notPrime[i]) {
				for (int i2=i*i;i2<MaxCache;i2+=i) {
					notPrime[i2]=true;
				}
			}
		}
		for (int i=0;i<MaxCache;i++) {
			if (!notPrime[i]) {
				primeNumbers[primeNumbersCount++]=i;
			}
		}
	}
	
	public static boolean isPrime (long l) {
		if (l==2 || l==3 || l==5 || l==7) {
			return true;
		} else if (l<2 || l%2==0) {
			return false;
		} else {
			for (long c=3;c*c<=l;c+=2) {
				if (l%c==0) {
					return false;
				}
			}
			return true;
		}
	}
	
	public static void main (String [] zzzz) {
		long before=System.currentTimeMillis();
		sieveOfEratosthenes();
		for (int i=0;primeNumbers[i]<9999;i++) {
			for (int i2=i+1;primeNumbers[i2]<9999;i2++) {
				String n1=String.valueOf(primeNumbers[i]);
				String n2=String.valueOf(primeNumbers[i2]);
				if (isPrime(Long.parseLong(n1+n2)) && isPrime(Long.parseLong(n2+n1))) {
					primePair[primeNumbers[i]][primeNumbers[i2]]=true;
					primePair[primeNumbers[i2]][primeNumbers[i]]=true;
				}
			}
		}
		int min=Integer.MAX_VALUE;
		String s="";
		for (int i=0;primeNumbers[i]<9999;i++) {
			for (int i2=i+1;primeNumbers[i2]<9999;i2++) {
				if (primePair[primeNumbers[i]][primeNumbers[i2]]) {
					for (int i3=i2+1;primeNumbers[i3]<9999;i3++) {
						if (primePair[primeNumbers[i]][primeNumbers[i3]] && primePair[primeNumbers[i2]][primeNumbers[i3]]) {
							for (int i4=i3+1;primeNumbers[i4]<9999;i4++) {
								if (primePair[primeNumbers[i]][primeNumbers[i4]] && primePair[primeNumbers[i2]][primeNumbers[i4]]&& primePair[primeNumbers[i3]][primeNumbers[i4]]) {
									for (int i5=i4+1;primeNumbers[i5]<9999;i5++) {
										if (primePair[primeNumbers[i]][primeNumbers[i5]] && primePair[primeNumbers[i2]][primeNumbers[i5]]&& primePair[primeNumbers[i3]][primeNumbers[i5]]&& primePair[primeNumbers[i4]][primeNumbers[i5]]) {
											min=Math.min(min,primeNumbers[i]+primeNumbers[i2]+primeNumbers[i3]+primeNumbers[i4]+primeNumbers[i5]);
											s=primeNumbers[i]+", "+primeNumbers[i2]+", "+primeNumbers[i3]+", "+primeNumbers[i4]+", "+primeNumbers[i5];
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(min+" | Combination : "+s);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}