/*
 * f t t f  5 
 * f 7 f f  f
 * 
 *  
 * check for numbers until sqrt(n + 1)
 * 
 * array -> set all the values initially as True
 * a value is true if it is not prime
 * a value is false if it is prime
 * 
 * this method is named sieve of eratosthenes.
 * 
 * addition.
 * 
 * m, n are two BigIntegers.
 * 
 * m = m+n
 * 
 * m = m.add(n); // addition for two BigInteger
 * 
 * 
 */

import java.math.BigInteger;


public class Euler10 {
	static int n_max = 2000000;
	static boolean not_primes [] = new boolean [2000000];
	public static void sieve_of_eratosthenes()
	{
	    not_primes[1] = true; // 1 is not a prime number
	    // 2 should be false because 2 is prime
	    
	    
	    
	    for (int i = 2; i*i <= n_max; i++)
	        if (!not_primes[i]) {
	            for (int j = i * i; j < n_max; j += i)
	                not_primes[j] = true;
	        }
	    
	    //at the worst condition this method has n*n/2 steps; 2*(10^6)^2 = 2*10^12;  
	
	}
	public static void main (String [] arg){
		sieve_of_eratosthenes ();
		BigInteger sum =  BigInteger.valueOf(0);
		for (int i = 1; i < n_max; i++){
			if (!not_primes[i]) sum = sum.add(BigInteger.valueOf(i)) ;
		}
		System.out.println (sum.toString());
	}
}
