public class euler {
	
	public static boolean isAbundantNumber (int num) {
		int count=1;
		for (int i=2;i*i<num;i++) {
			if (num%i==0) {
				count=count+(i+(num/i));
			}
		}
		if ((double)(int)Math.sqrt(num)==Math.sqrt(num)) {
			count=count+(int)Math.sqrt(num);
		}
		return (count>num);
	}
	
	public static void main (String [] abc) {
		long before=System.currentTimeMillis();
		int [] abundantNumbers=new int [28124];
		int abundantNumbersCount=0;
		for (int i=12;i<28112;i++) {
			if (isAbundantNumber(i)) {
				abundantNumbers[abundantNumbersCount++]=i;
			}
		}
		boolean [] sumOfAbundanceNumber=new boolean [28124];
		for (int i=0;i<abundantNumbersCount;i++) {
			for (int i2=i;i2<abundantNumbersCount;i2++) {
				int sum=abundantNumbers[i]+abundantNumbers[i2];
				if (sum<28124) {
					sumOfAbundanceNumber[sum]=true;
				} else {
					break;
				}
			}
		}
		int sum=0;
		for (int i=1;i<28124;i++) {
			if (!sumOfAbundanceNumber[i]) {
				sum=sum+i;
			}
		}
		long after=System.currentTimeMillis();
		System.out.println(sum);
		System.out.println("Took "+(after-before)+"ms.");
	}
	
}