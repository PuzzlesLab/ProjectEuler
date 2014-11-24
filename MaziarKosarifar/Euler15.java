
public class Euler15 {
	

	
	public static long c (int n, int m) {
		int i, j;
		long bc [][] = new long[500][500];
		
		for (i = 0; i <=n; i++) bc [i][0] = 1;
		// we know that  c (n, 0) = 1;
		// we know that c (n, n) = 1;
		
		for (j =0; j <=n;j++) bc[j][j] = 1;
		
		
		// by pascal c (n,r) = c(n-1, r-1) + c(n-1, r)
 		
		for (i =1; i<=n; i++)
			for (j =1; j <i;j++)
				//c(i, j)= c(i-1, j-1) + c (i-1, j) 
				bc[i][j] = bc[i-1][j-1] + bc[i-1][j];
		
		return bc[n][m];
	}
	
	public static void main (String[] arg){
		
		// we know that it is a 20*20 grid so we have to move r 20 times and 
		// move down 20 times. So totally there are 40 places. and 20 rights. 
		// all remaining empty locations are for down.
		
		// The question actaully wants us to calculate c(40, 20);
		
		
		System.out.println (c (40, 20));
	}
}

