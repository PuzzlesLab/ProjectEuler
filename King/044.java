public class euler {
	
	/*
	 * 2P = 3n^2 - n
	 * 3n^2 - n - 2P = 0
	 * n = [1+sqrt(1+24P)] / 6
	 * if n is int, then n is pentagonal numbers.
	 */
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		int [] pentagonalNumbers=new int [10001];
		int smallestDiff=Integer.MAX_VALUE;
		pentagonalNumbers[0]=1;
		for (int n=1;n<10001;n++) {
			/* P(n) = 0.5n(3n-1);
			 * P(n-1) = 0.5(n-1)[3(n-1)-1];
			 * P(n) - P(n-1) = 3*n + 1;
			*/
			pentagonalNumbers[n]=pentagonalNumbers[n-1]+(3*n+1);
		}
		for (int i=0;i<10001 && smallestDiff==Integer.MAX_VALUE;i++) {
			for (int i2=i+1;i2<10001 && smallestDiff==Integer.MAX_VALUE;i2++) {
				double sumSqrt=(1+Math.sqrt(1+24*(pentagonalNumbers[i]+pentagonalNumbers[i2])))/6; 
				double diffSqrt=(1+Math.sqrt(1+24*(Math.abs(pentagonalNumbers[i]-pentagonalNumbers[i2]))))/6; 
				if (sumSqrt==(double)(int)sumSqrt && diffSqrt==(double)(int)diffSqrt) {
					smallestDiff=Math.abs(pentagonalNumbers[i]-pentagonalNumbers[i2]);
				}
			}
		}
		System.out.println(smallestDiff);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
} 