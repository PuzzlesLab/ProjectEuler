public class euler {
	
	public static boolean isPalindrome (String s) {
		char [] c=s.toCharArray();
		for (int i=0;i<c.length/2;i++) {
			if (c[i]!=c[c.length-1-i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main (String [] abc) {
		long start=System.currentTimeMillis();
		int sum=0;
		for (int i=1;i<1000000;i++) {
			if (isPalindrome(String.valueOf(i)) && isPalindrome(Integer.toBinaryString(i))) {
				sum+=i;
			}
		}
		System.out.println(sum);
		System.out.println("Took "+(System.currentTimeMillis()-start)+"ms.");
	}
}