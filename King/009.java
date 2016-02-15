public class euler {
	
	public static void main (String [] abc) {
		int answer=0;
		for (int a=1;a<1000 && answer==0;a++) {
			for (int b=a+1;b<=1000 && answer==0;b++) {
				double c=Math.sqrt(a*a+b*b);
				int cInt=(int)c;
				if (a+b+c>1000) {
					break;
				} else if (c==(double)cInt && a+b+cInt==1000) {
					answer=a*b*cInt;
				}
			}
		}
		System.out.println(answer);
	}
}