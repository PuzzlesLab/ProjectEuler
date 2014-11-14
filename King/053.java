import java.math.BigInteger;

public class euler {
	
	public static BigInteger [] fractorial=new BigInteger [101];
	
	public static void cacheFractorial () {
		fractorial[0]=BigInteger.ONE;
		for (int i=1;i<fractorial.length;i++) {
			fractorial[i]=fractorial[i-1].multiply(BigInteger.valueOf((i)));
		}
	}
	
	public static BigInteger nCr (int n, int r) {
		return fractorial[n].divide(fractorial[r].multiply(fractorial[n-r]));
	}
	
	public static void main (String [] args) {
		double before=System.currentTimeMillis();
		cacheFractorial();
		int count=0;
		BigInteger million=BigInteger.valueOf(1000000);
		for (int n=0;n<fractorial.length;n++) {
			for (int r=0;r<n;r++) {
				if (nCr(n,r).compareTo(million)>0) {
					count++;
				}
			}
		}
		System.out.println(count);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}