import java.math.BigInteger;

public class euler {
	
	public static void main (String [] abc) {
		BigInteger bi=BigInteger.ONE;
		BigInteger two=new BigInteger("2");
		for (int i=0;i<1000;i++) {
			bi=bi.multiply(two);
		}
		BigInteger sum=BigInteger.ZERO;
		while (bi.compareTo(BigInteger.ZERO)>0) {
			sum=sum.add(bi.remainder(BigInteger.TEN));
			bi=bi.divide(BigInteger.TEN);
		}
		System.out.println(sum.toString());
	}
}