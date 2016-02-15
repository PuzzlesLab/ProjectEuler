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
		for (int i=999;i>900;i--) {
			for (int i2=i-1;i2>=900;i2--) {
				int prod=i*i2;
				if (prod<=largest) {
					break;
				} else if (isPalindrome(String.valueOf(prod))) {
					largest=prod;
					break;
				}
			}
		}
		System.out.println(largest);
	}
}