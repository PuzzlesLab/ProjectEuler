public class euler {
	
	// caches.
	public static int [] fractorial = new int [10];
	public static int [] nextTerm = new int [1000000];
	public static int [] chainCount = new int [nextTerm.length];
	
	public static void cacheFractorial () {
		fractorial[0]=1;
		for (int i=1;i<10;i++) {
			fractorial[i]=fractorial[i-1]*i;
		}
	}
	
	public static int getNextTerm (int num) {
		int next=0;
		while (num>0) {
			next=next+fractorial[num%10];
			num/=10;
		}
		return next;
	}
	
	public static int getChainCount (int num, boolean [] flag) {
		if (num<nextTerm.length) {
			if (flag[num]) {
				flag[num]=false;
				return 0;
			} else {
				if (chainCount[num]==0) {
					flag[num]=true;
					if (nextTerm[num]==0) {
						nextTerm[num]=getNextTerm(num);
					}
					int value=1+getChainCount(nextTerm[num],flag);
					chainCount[num]=value;
					flag[num]=false;
				}
				return chainCount[num];
			}
		} else {
			return 1+getChainCount(getNextTerm(num),flag);
		}
	}
	
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		cacheFractorial();
		boolean [] flag=new boolean [nextTerm.length];
		int count=0;
		for (int i=1;i<1000000;i++) {
			if (getChainCount(i,flag)==60) {
				count++;
			}
		}
		System.out.println(count);
		long after=System.currentTimeMillis();
		System.out.println("Took "+(after-before)+" ms.");
	}
	
}