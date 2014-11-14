import java.math.BigInteger;

public class euler {
	
	public static BigInteger [] f=new BigInteger [100000000];
	
	public static BigInteger fibonacciNum (int num) {
		if (f[num]==null) {
			f[num]=fibonacciNum(num-1).add(fibonacciNum(num-2));
		}
		return f[num];
	}
	
	public static void main (String [] abc) {
		f[1]=BigInteger.ONE;
		f[2]=BigInteger.ONE;
		for (int i=3;true;i++) {
			if (fibonacciNum(i).toString().length()==1000) {
				System.out.println(i);
				break;
			}
		}
	}
	
	
}