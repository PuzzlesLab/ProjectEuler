/*
 * 1001
 * 121 
 * 91 * 99 = 9009
 * 
 * is_pal -> bool (true, false)
 * is_pal (integer n)
 * n -> string str
 * if str is palindrome true
 * else its' false.
 * 
 * 
 * 123
 * asa true
 * 123456
 * helleh
 *  
 *  6 - 2 - 1
 *  
 * zoo false
 * 
 * 
 * 
 * 
 * 100 - 999
 * 
 * 
 */





public class Euler4 {
	public static boolean is_pal (int number){
		String str = Integer.toString(number);
		for (int i = 0; i < str.length ()/2; i++){
			if (str.charAt (i) != str.charAt(str.length() - i - 1)) return false;
		}
		return true;
	}
	public static void main (String[] args){
		int max = 0;
		for (int i = 100; i < 1000; i++){
			for (int j = i; j < 1000; j++)
				if (is_pal(i*j) && i*j > max) max = i*j;
		}
		
		System.out.println (max);
	}
}
