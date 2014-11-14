public class euler {
	
	public static boolean isPalindrome (String s) {
		for (int i=0;i<s.length()/2;i++) {
			if (s.charAt(i)!=s.charAt(s.length()-i-1)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main (String [] zzz) {
		int largest=0;
		for (int i=999;i>=100;i--) {
			for (int i2=999;i2>=100;i2--) {
				if (isPalindrome(String.valueOf(i*i2)) && ((i*i2)>largest)) {
					largest=i*i2;
					break;
				}
			}
		}
		System.out.println(largest);
	}
}