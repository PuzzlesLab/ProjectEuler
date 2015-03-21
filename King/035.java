public class euler {
	
	public static int [] primeNumbers=new int [78498];
	public static int primeNumbersCount=0;
	public static boolean [] notPrime=new boolean [1000001];
	public static boolean [] checked=new boolean [1000001];
	
	public static void sieveOfEratothenes () {
		for (int i=2;i*i<1000001;i++) {
			if (!notPrime[i]) {
				for (int i2=i*i;i2<1000001;i2+=i) {
					notPrime[i2]=true;
				}
			}
		}
		primeNumbers[primeNumbersCount++]=2;
		for (int i=3;i<1000001;i+=2) {
			if (!notPrime[i]) {
				primeNumbers[primeNumbersCount++]=i;
			}
		}
	}
	
	public static int circularPrime (int num) {
		if (num<10) {
			checked[num]=true;
			return 1;
		} else if (num%2==0) {
			return 0;
		}
		int rotated=num;
		int divisor=(int)Math.pow(10,(int)Math.log10(num));
		int count=0;
		do {
			checked[rotated]=true;
			if (notPrime[rotated]) {
				return 0;
			} else {
				int firstDigit=rotated/divisor;
				rotated=(rotated%divisor)*10+firstDigit;
				if (notPrime[rotated]) {
					checked[rotated]=true;
					return 0;
				} else {
					count++;
				}
			}
		} while (rotated!=num);
		return count;
	}
	
	public static void main (String [] abc) {
		long start=System.currentTimeMillis();
		sieveOfEratothenes();
		int count=0;
		for (int i=0;i<primeNumbersCount;i++) {
			if (!checked[primeNumbers[i]]) {
				count+=circularPrime(primeNumbers[i]);
			}
		}
		System.out.println(count);
		System.out.println("Took "+(System.currentTimeMillis()-start)+"ms");
	}
}