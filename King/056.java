import java.math.BigInteger;

public class euler {
	
	public static int powSum (int base, int exp) {
		BigInteger b=BigInteger.valueOf(base);
		b=b.pow(exp);
		int sum=0;
		while (b.compareTo(BigInteger.ZERO)>0) {
			sum+=b.remainder(BigInteger.TEN).intValue();
			b=b.divide(BigInteger.TEN);
		}
		return sum;
	}
	
	public static void main (String [] args) {
		double before=System.currentTimeMillis();
		int max=0;
		for (int a=1;a<100;a++) {
			for (int b=2;b<100;b++) {
				max=Math.max(max,powSum(a,b));
			}
		}
		System.out.println(max);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}