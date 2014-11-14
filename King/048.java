import java.math.BigInteger;

public class euler {
	
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		BigInteger sum=BigInteger.ZERO;
		for (int i=1;i<=1000;i++) {
			sum=sum.add(new BigInteger(String.valueOf(i)).pow(i));
		}
		String s=sum.toString();
		System.out.println(s.substring(s.length()-10,s.length()));
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}