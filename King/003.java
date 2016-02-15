public class euler2 {
	
	public static long largestPrimeFactor (long l) {
		long factor=3;
		for (;factor<=l;factor+=2) {
			while (l%factor==0) {
				l/=factor;
			}
		}
		return factor-2;
	}
	
	public static void main (String [] zzz) {
		System.out.println(largestPrimeFactor(600851475143L));
	}
}
