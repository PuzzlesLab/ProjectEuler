/*
 * Numbers that are divisible by 3 or 5; 
 * for n = 10 we have { 3, 5, 6, 9} and their sum is 
 * sum = 3 + 5 + 6 + 9;
 * sum is 23.
 * 
 * Numbers have few conditions they are only divisible by 3
 * or they are only divisible by 5
 * or both 3 and 5
 * or non of them.
 * 
 * So here is the table :
 * 
 * 
 * 3  |   5  | condition
 * _________
 * 0  |   0  |  bad
 * 0  |   1  |  good
 * 1  |   0  |  good
 * 1  |   1  |  good
 * 
 * And as this table is look like an OR table then we use or
 * 
 * So the condition would be 
 * if (i%3 == 0 || i%5 == 0) 
 * 
 * and if the condition is true so we can use that number to 
 * get the sum.
 * 
 * 
 */









public class Euler1 {

	public static void main (String[] args){
		int n = 1000, sum = 0;
	    
	    for (int i = 1; i < n; i++){
	        if (i%3 == 0 || i%5 == 0) sum+= i;
	    }
	    System.out.println (sum);
	}
}

