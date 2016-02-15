package euler;

public class euler {
	
	public static void main (String[] args) {
		long before=System.currentTimeMillis();
		long [] dp=new long [101];
		dp[0]=1;
		for (int i=1;i<100;i++) {
			for (int i2=i;i2<=100;i2++) {
				dp[i2]=dp[i2]+dp[i2-i];
			}
		}
		long after=System.currentTimeMillis();
		System.out.println(dp[100]);
		System.out.println("Took "+(after-before)+" ms.");
	}
	
}