/*
 * a *a + b * b = c * c;
 * 
 * normal triangle 
 * 
 * *   |\
	 * | \
	 * |__\
	 * 
 * 
 * 
 * a ^ 2 + b^2 - 2ab*cos(angle ) = c ^ 2
 * angle 90 degree;
 * cos (90 degree) = cos (pi/2) = 0
 * 
 * 2*a*b*cos(angle = pi/2) = 0;
 * 
 * a ^ 2 + b^2 = c^2
 * 
 * 
 * (a, b, c)
 * 
 * a + b + c = 1000;
 * a ^ 2 +  b^ 2 = c ^ 2;
 * 
 *  for (a)
 *  	for (b)
 *  		for (c)
 *  
 *  (a, b, c)
 *  (b, a , c)
 *  c > a , c > b
 * 
 * 
 * 
 */



public class Euler9 {
	public static void main (String[] arg){
		for (int i = 1000; i > 0; i--){
			for (int j = i; j > 0; j--){
				
				
				
				for (int z = j; z > 0; z--){
					if ((i*i) == (j*j) + (z*z) && (i + j + z == 1000)) System.out.println (i*j*z);
					// the number of times this if condition is checked is greatly less than 1000 ^ 3;
				
				}
			}
		}
	}
}
