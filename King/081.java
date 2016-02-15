import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class euler {
	
	public static void main (String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("D:\\Documents\\King\\Desktop\\p081_matrix.txt"));
		int size=80;
		int [][] value=new int [size][size];
		for (int i=0;i<value.length;i++) {
			String [] s=br.readLine().split(",");
			for (int i2=0;i2<value.length;i2++) {
				value[i][i2]=Integer.parseInt(s[i2]);
			}
		}
		
		long before=System.currentTimeMillis();
		int [][] dp=new int [size][size];
		for (int i=0;i<dp.length;i++) {
			for (int i2=0;i2<dp.length;i2++) {
				dp[i][i2]=value[i][i2];
			}
		}
		
		for (int i=0;i<dp.length;i++) {
			for (int i2=0;i2<dp.length;i2++) {
				if (i-1>=0 && i2-1>=0) {
					dp[i][i2]=dp[i][i2]+Math.min(dp[i-1][i2],dp[i][i2-1]);
					//either come from left or up.
				} else if (i-1>=0){
					dp[i][i2]=dp[i][i2]+dp[i-1][i2];
					//at the left, so only can come from up.
				} else if (i2-1>=0){
					dp[i][i2]=dp[i][i2]+dp[i][i2-1];
					//at the top, so only can come from right.
				}
			}
		}
		long after=System.currentTimeMillis();
		br.close();
		
		System.out.println(dp[size-1][size-1]);
		System.out.println("Used "+(after-before)+" ms.");
	}
	
}