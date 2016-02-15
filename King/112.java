public class euler {
	
	public static boolean isBouncy (int num) {
		char [] c=String.valueOf(num).toCharArray();
		boolean increase=false;
		boolean decrease=false;
		for (int i=1;i<c.length;i++) {
			if (c[i]>c[i-1]) {
				increase=true;
			} else if (c[i]<c[i-1]) {
				decrease=true;
			}
			if (increase && decrease) {
				break;
			}
		}
		return increase && decrease;
	}
	
	public static void main (String[] args) {
		long before=System.currentTimeMillis();
		//given 21780 = 90%, so we can start from here.
		int bouncyCount=19602; //21780 * 0.9
		int currentNum=21780;
		while ((double)bouncyCount/currentNum!=0.99) {
			currentNum++;
			if (isBouncy(currentNum)) {
				bouncyCount++;
			}
		}
		long after=System.currentTimeMillis();
		System.out.println(currentNum);
		System.out.println("Used "+(after-before)+"ms.");
	}
	
}