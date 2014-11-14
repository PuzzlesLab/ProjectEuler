public class euler {
	
	public static void main (String [] abc) {
		boolean found=false;
		for (int a=1;a<=1000;a++) {
			for (int b=1;b<=1000;b++) {
				double cTest1=Math.sqrt(a*a+b*b);
				double cTest2=(double)(int)cTest1;
				if (cTest1==cTest2) {
					int c=(int)cTest2;
					if (a+b+c==1000) {
						System.out.println(a*b*c);
						found=true;
					}
				}
				if (found) {
					break;
				}
			}
			if (found) {
				break;
			}
		}
	}
}