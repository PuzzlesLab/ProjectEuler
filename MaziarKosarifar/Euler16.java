import java.math.BigInteger;
/*
 * BigIntegers => power function. when we are talking about number a ^ b
 * and b is an integer then what it means is : 
 * 
 * (a * a* a* a* ... * a ) b  a-s that are multipled to gives us the value of a^b
 * 
 *  
 *  2 ^ 4 is (2 ^ 2) ^ 2
 *  4 operation 2 * 2 = 4 => 4 * 2 = 8 => 8 * 2 = 16
 *  
 * (2 ^ 2) ^ 2 : only needs 2 operations. 2^2 = 4; 4 * 4 = 16.
 * 
 * 
 */



public class Euler16 {
	
	//public BigIntpow (BigInteger)
	
	
	public static void main (String[] arg){
		BigInteger n = new BigInteger (String.valueOf("1"));
		for (int i = 0; i < 1000; i++) n = n.multiply(new BigInteger (String.valueOf("2")));
		// = 2 ^ 1000
		
		// n = 2 ^ 1000 => find string of n and then I sum up its digits.
		
		
		String s = n.toString();
		int sum = 0;
		for (int i= 0; i < s.length (); i++)
			sum+= Integer.parseInt("" + s.charAt(i));
		System.out.println (sum);
	}
	
	
}
