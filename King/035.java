public class euler {
	
	public static int [] primeNumbers=new int [78498];
	public static int primeNumbersCount=0;
	
	public static void sieveOfEratothenes (int end) {
		boolean [] flag=new boolean [end+1];
		for (int i=2;i*i<=end;i++) {
			if (!flag[i]) {
				for (int i2=i*i;i2<=end;i2+=i) {
					flag[i2]=true;
				}
			}
		}
		for (int i=2;i<=end;i++) {
			if (!flag[i]) {
				primeNumbers[primeNumbersCount++]=i;
			}
		}
	}
	
	public static boolean isPrime (int num) {
		//Since the prime numbers are in ascending order, we can use binary search.
		int mid;
		int min=0;
		int max=primeNumbers.length-1;
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
	
	public static boolean isCircularPrime (int num) {
		if (num<10) {
			return true;
		} else if (num%2==0) {
			return false;
		}
		int divisor=(int)Math.pow(10,(int)Math.log10(num));
		for (int i=(int)Math.log10(num);i>0;i--) {
			//rotate n times for n digits.
			int front=num/divisor;
			if (front%2==0) {
				return false;
			} else {
				num=(num%divisor)*10+front;
				if (!isPrime(num)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main (String [] abc) {
		long start=System.currentTimeMillis();
		sieveOfEratothenes(1000000);
		int count=0;
		for (int i=0;i<primeNumbersCount;i++) {
			if (isCircularPrime(primeNumbers[i])) {
				count++;
			}
		}
		System.out.println(count);
		System.out.println("Took "+(System.currentTimeMillis()-start)+"ms");
	}
}