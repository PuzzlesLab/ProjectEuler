public class euler {

	public static int [] primeCache=new int [12989*2+1];
	//0=yet to check, 1=is prime, 2=is not prime.
	//12989? After testing, the maximum prime number to be tested is 12989!
	
	public static boolean isPrime (int num) {
		if (primeCache[num+12989]==0) {
			if (num==2 || num==3 || num==5 || num==7) {
				primeCache[num+12989]=1;
			} else if (num%2==0 || num<2) {
				primeCache[num+12989]=2;
			} else {
				for (int i=3;i*i<=num;i+=2) {
					if (num%i==0) {
						primeCache[num+12989]=2;
					}
				}
				if (primeCache[num+12989]==0) {
					primeCache[num+12989]=1;
				}
			}
		}
		return (primeCache[num+12989]==1);
	}
	
	public static int length (int a, int b) {
		int n=0;
		while (true) {
			int result=n*n+a*n+b;
			if (!isPrime(result)) {
				break;
			}
			n++;
		}
		return n;
	}
	
	public static void main (String [] zz) {
		int maxA=0, maxB=0, maxLength=0;
		for (int a=-999;a<1000;a++) {
			for (int b=-997;b<1000;b+=2) { //b must be prime. Why? When n=0, b must be prime to create a prime.
				int l=length(a,b);
				if (l>maxLength) {
					maxA=a;
					maxB=b;
					maxLength=l;
				}
			}
		}
		System.out.println(maxA*maxB);
	}
}