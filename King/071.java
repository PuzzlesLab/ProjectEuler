public class euler {

	public static boolean ishcfOne (int a, int b) {
		int big=Math.max(a,b);
		int small=Math.min(a,b);
		while (small!=1) {
			if (big%small==0) {
				if (small==1) {
					return true;
				} else {
					return false;
				}
			} else {
				small=big%small;
			}
		}
		return true;
	}
	
	public static void main (String [] zzzz) throws Exception {
		long before=System.currentTimeMillis();
		double target=3/7.0;
		double previous=2/5.0;
		int numerator=2;
		int denominator=5;
		for (int d=1000000;d>=8;d--) {
			int n=(int)(target*d);
			if (((double)(n)/d)>previous && ishcfOne(n,d)) {
				numerator=n;
				denominator=d;
				previous=(double)n/d;
			}
		}
		System.out.println(numerator+"/"+denominator);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}