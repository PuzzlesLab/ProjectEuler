public class euler {
	
	public static int gcd (int a, int b) {
		if (b==0)
			return a;
		else
			return gcd(a,a%b);
	}
	
	public static void main (String [] abc) {
		int numerator=1;
		int denominator=1;
		for (int i=11;i<100;i++) {
			int lastDigit=i%10;
			int start=Math.max(lastDigit*10,i+1);
			int end=Math.max((lastDigit+1)*10,i);
			for (int i2=start;i2<end;i2++) {
				double d1=(double)i/i2; // 49/98
				double d2=((double)(i/10))/(i2%10); // 4/8
				if (d1==d2) {
					numerator*=i;
					denominator*=i2;
				}
			}
		}
		System.out.println(denominator/gcd(numerator,denominator));
	}

}