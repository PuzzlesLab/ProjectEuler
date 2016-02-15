public class euler {
	
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		long sum=0;
		long modz=10000000000L;
		for (int i=1;i<=1000;i++) {
			long currInd=1;
			for (int i2=0;i2<i;i2++) {
				currInd*=i;
				currInd%=modz;
				//we are only interested in last 10 digits.
			}
			sum+=currInd;
			sum%=modz;
			//we are only interested in last 10 digits.
		}
		System.out.println(sum);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}