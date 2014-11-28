import java.math.BigInteger;

/*
 * n! = n * (n-1)!
 * n! = 1 * 2 * 3 * ... * (n-1) * n
 * p = 1;
 * for (i = 1, i <= n; i++){
 * 	p *= i;
 * }
 * BigInteger ()
 * BigInteger n = new BigInteger ("1");
 * 
 * for (int i = 1, i <= n; i++){
 *   n = n.mutliply (new BigInteger (new Integer(i).toString()); 
 *   // n = n.multiply (new BigInteger ("" + i));
 * }
 * 
 * String digits = n.toString();
 * int sum = 0;
 * for (int 0; i < digits.length (); i++){
 * 	sum += Integer.parseInt(digits.substring (i, i+1));
 * }
 * 
 */

public class Euler20 {
	
	public static BigInteger reFactorial (int n){
		if (n < 2) {
			// n =1 or n = 0
			return (new BigInteger ("1"));
		}
		else {
			return reFactorial(n-1).multiply(new BigInteger ("" + n));
		}
	}
	
	
	public static void main (String [] arg){
		BigInteger n = reFactorial (100);//new BigInteger ("1");
		/*for (int i = 1; i <= 100; i++){
			n = n.multiply(new BigInteger(new Integer(i).toString()));	
		}*/
		
		
		
		
		System.out.println (n.toString());
		int sum = 0;
		for (int i = 0; i < n.toString().length(); i++){
			sum+= Integer.parseInt(n.toString().substring (i, i+1));
		}
		
		
		
		System.out.println (sum);
	}
}
