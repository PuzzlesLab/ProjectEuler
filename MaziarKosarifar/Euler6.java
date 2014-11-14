import java.math.BigInteger;



public class Euler6 {
	public static void main (String[] args){
		BigInteger a = BigInteger.valueOf (0);
		BigInteger b = BigInteger.valueOf (0);
		for (int i = 1; i < 101; i++){
			a = a.add(BigInteger.valueOf(i));
			b = b.add(BigInteger.valueOf(i*i));
		}
		a = a.multiply(a);
		System.out.println (a.subtract(b).toString());
	}
}
