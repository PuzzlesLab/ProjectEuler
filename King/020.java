import java.math.BigInteger;

public class test {
	
	public static void main (String [] abc) {
		BigInteger bi=BigInteger.ONE;
		for (int i=100;i>=2;i--) {
			bi=bi.multiply(new BigInteger(String.valueOf(i)));
		}
		char [] c=bi.toString().toCharArray();
		int sum=0;
		for (int i=0;i<c.length;i++) {
			sum=sum+(c[i]-'0');
		}
		System.out.println(sum);
	}
}