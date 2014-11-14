/*
 * 
 * 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28
 * 
 * f(n) = f(n-1) + n
 * 
 * f(n) = (n*(n+1))/2
 * 
 * f(1) = 1*2/2 = 1
 * f(2) = (2*3)/2 = 3
 * 
 * 1 : n = 1
 * 2 : n = n + 2
 * 3 : n = n + 3
 * => each time n += counter
 * 
 * 
 * d is the number of divisors.
 * 
 * to find the div of a #n we start from 1 until square root of n =>  1 -> sqrt (n)

 * 
 * number of div >= 500;
 * 500 is an even number and perfect squares has odd number of div.
 * 1
 * 
 * 
 * i * i < n
 * i= 1; i *i < n; i++
 *  d for divisors.
 *  
 *  
 *  count 2, 3, 4 , ...
 *  
 *  
 *  n = 1, n += count; 
 */




public class Euler12 {
	public static void main (String[] arg){
		int n = 1;
		int d = 1, count = 2;
		while (d <= 500) {
			d=0;
			n += count;
			for (int i = 1; i * i< n; i++){
				// for each number i that n%i == 0=> there is another number n/i that also divides n
				
				
				if (n%i == 0 ) d+=2;
 			}
			count ++;
		}
		System.out.println (n);
	}
}
