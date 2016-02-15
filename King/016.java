import java.math.BigInteger;

public class euler2 {
	
	public static void main (String [] abc) {
		BigInteger bi=BigInteger.ONE;
		BigInteger base=new BigInteger("256");
		for (int i=0;i<125;i++) {
			bi=bi.multiply(base);
		}
		int sum=0;
		char [] c=bi.toString().toCharArray();
		for (int i=0;i<c.length;i++) {
			sum+=(c[i]-'0');
		}
		System.out.println(sum);
	}
}