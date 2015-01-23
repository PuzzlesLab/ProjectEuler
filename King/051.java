public class euler {
	
	public static int MaxCache=2000001;
	public static boolean [] notPrime=new boolean [MaxCache];
	public static int [] primeNumbers=new int [MaxCache];
	public static int primeNumbersCount=0;
	
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
			if (notPrime[i]==false) {
				primeNumbers[primeNumbersCount++]=i;
			}
		}
	}
	
	public static void testNDigits(int digitsCount, int targetPrimeCount) {
		int minDigitsIndex=0;
		while (primeNumbers[minDigitsIndex]<(int)Math.pow(10,digitsCount-1)) {
			minDigitsIndex++;
		}
		for (int i=minDigitsIndex;primeNumbers[i]<(int)Math.pow(10,digitsCount);i++) {
			String numStr=String.valueOf(primeNumbers[i]);
			for (char replaceC='0';replaceC<(9-targetPrimeCount+1)+'0';replaceC++) {
				//target prime count=8, so the testing number should starts from 0 or 1 or 2, otherwise
				//it wont satisfy the condition, as 3 to 9 only has 7 numbers.
				String testPattern=numStr.replace(replaceC,'@');
				if (!testPattern.equals(numStr)) {
					int primeCount=1;
					for (int toReplace=replaceC+1;toReplace<='9';toReplace++) {
						String testReplaced=testPattern.replace('@',(char)toReplace);
						if (notPrime[Integer.parseInt(testReplaced)]==false) {
							primeCount++;
						}
					}
					if (primeCount==targetPrimeCount) {
						System.out.println("Result ["+digitsCount+" digits] : "+numStr);
						return;
					}
				}
			}
		}
		System.out.println("Result ["+digitsCount+" digits] : Not found");
	}
	
	public static void main (String [] zzzz) {
		long beforeTime=System.currentTimeMillis();
		sieveOfEratosthenes();
		testNDigits(5,8);
		testNDigits(6,8);
		System.out.println("Took "+(System.currentTimeMillis()-beforeTime)+"ms.");
	}
}
