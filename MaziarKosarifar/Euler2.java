
public class Euler2 {
	public static void main (String[] args){
	    int a = 1, b = 2, temp = b;
	    int sum = 0;
	    while (b <= 4000000){
	        if (b%2 == 0) sum += b;
	        temp = b;
	        b += a;
	        a = temp;
	        
	    }
	    System.out.println (sum);

	}
}
