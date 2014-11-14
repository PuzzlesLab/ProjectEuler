import java.math.BigInteger;

public class euler {
	
	public static BigInteger largestPrimeFactor (BigInteger bi) {
		BigInteger factor=new BigInteger("2");
		for (;factor.compareTo(bi)<=0;factor=factor.add(BigInteger.ONE)) {
			if (bi.remainder(factor)==BigInteger.ZERO) {
				bi=bi.divide(factor);
				factor=factor.subtract(BigInteger.ONE);
			}
		}
		return factor;
	}
	
	public static void main (String [] zzz) {
		System.out.println(largestPrimeFactor(new BigInteger("600851475143")).toString());
	}
}