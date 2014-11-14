/*
 * What is a prime number ? 
 * A prime number is a number that it is divisible by 1 and itself.  ( except one! )
 * 
 * For example 2 is a prime number because only 1 and 2 can divide 2. 
 * 
 * 3 is also a prime number as it is only divisible by 1 and 3.
 * 
 * so in another word we can say that a prime number is only divisible by 2 positive integers.
 * 
 * 
 * How to find if a number is prime or not ? 
 * 
 * There are two things that we are sure about : 
 * 
 * 1. all integer numbers are divisible by 1 ( so we don't need to check if they are or not)
 * 
 * 2. all numbers are divisible by themselves.
 * 30 is not a prime number
 * 
 * 30 % 1 = 0
 * 30 % 30 = 0
 * 
 * 30 % 5 = 0
 * 30%2 = 0
 * 
 * 
 * So we start from 2. and go until the square root of that number. 
 * 
 * for example to check 35 : 
 * 
 * n % a;
 * a > sqrt (n)
 * 
 * n/a = b;
 * 
 * prove : {
 * b*a = n;
 * a > sqrt(n)
 * b < sqrt (n)
 * }
 * 
 * if both a and b are greater than sqrt(n) what will happen ? 
 * 
 * a * b > sqrt (n ) * sqrt (n) > n a * b != n;
 * 
 * 
 * we start with 2 until sqrt(35) which is 5.9
 * 
 * 35
 * 
 * 2 - 6
 * 35%2 = 1;
 * 35%3 = 2
 * 35%4 = 3
 * 35%5 = 0;
 * 
 * sqrt (n+1)
 * 
 * if ( is_prime (n) )
 * 
 * 
 */
public class Euler7 {
	public static boolean is_prime (int number){
		if (number < 2) return false;
		for (int i = 2; i*i < number+1; i++){
			if (number%i==0) return false;
		}
		
		return true;
	}
	public static void main (String[] args){
		int counter = 0;
		int i = 1;
		while (counter < 10001){
			i ++;
			if (is_prime (i)) counter ++;
			
		}
		System.out.println (i);
	}
	
}
