public class test {
	
	public static long [][] dp=new long [21][21];
	
	public static void main (String [] abc) {
		for (int i=0;i<21;i++) {
			dp[0][i]=1;
			dp[i][0]=1;
		}
		for (int i=1;i<21;i++) {
			for (int i2=1;i2<21;i2++) {
				dp[i][i2]=dp[i-1][i2]+dp[i][i2-1];
			}
		}
		System.out.println(dp[20][20]);
	}
}