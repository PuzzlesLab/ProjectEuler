public class euler {
	
	/*
	 * 2P = 3n^2 - n
	 * 3n^2 - n - 2P = 0
	 * n = [1+sqrt(1+24P)] / 6
	 * if n is int, then n is pentagonal numbers.
	 */
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		int smallestDiff=Integer.MAX_VALUE;
		int [] Pn=new int [5001];
		for (int j=2;smallestDiff==Integer.MAX_VALUE;j++) {
			if (Pn[j]==0) {
				Pn[j]=j*(3*j-1)/2;
			}
			for (int k=j-1;k>=1;k--) {
				if (Pn[k]==0) {
					Pn[k]=k*(3*k-1)/2;
				}
				double sumSqrt=(1+Math.sqrt(1+24*(Pn[j]+Pn[k])))/6; 
				double diffSqrt=(1+Math.sqrt(1+24*(Pn[j]-Pn[k])))/6; 
				if (sumSqrt==(double)(int)sumSqrt && diffSqrt==(double)(int)diffSqrt) {
					smallestDiff=Pn[j]-Pn[k];
				}
			}
		}
		System.out.println(smallestDiff);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
} 