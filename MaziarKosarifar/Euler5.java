
public class Euler5 {
	public static int gcd (int a, int b){
		if (b==0) return a;
		else return gcd(b, a%b);
	}
	public static void main (String[] args){
		int ans = 1;
		
		for (int i = 2; i < 21; i++){
			ans *= i / gcd (ans, i);
		}
		System.out.println (ans);
	}
}
