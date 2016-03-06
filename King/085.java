public class Euler {
	
	public static void main (String [] zzz) {
		/* - Using formula for sum of an AP for an axis.
		/    a=1, d=1, we shall get n(n+1)/2;
		   - Then proceed to calculate for both axes and multiply them.
		   - The formula would be [(x)(x+1)(y)(y+1)]/4
		 */
		int minDiff=2000001;
		int area=0;
		int target=2000000;
		for (int x=2;x<100;x++) {
			for (int y=1;y<=x;y++) {
				int totalCount=(x*(x+1)*y*(y+1))/4;
				int diff=Math.abs(target-totalCount);
				if (minDiff>diff) {
					area=x*y;
					minDiff=diff;
				}
			}
		}
		System.out.println(area);
	}
} 