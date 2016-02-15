public class euler {
	
	public static boolean [] arriveAt89=new boolean [10000000];
	public static boolean [] checked=new boolean [10000000];
	public static int [] pow10=new int [9];
	
	public static void computePow10 () {
		pow10[0]=1;
		for (int i=1;i<pow10.length;i++) {
			pow10[i]=pow10[i-1]*10;
		}
	}
	
	public static boolean computeChain (int num) {
		if (num==1) {
			return false;
		} else if (num==89) {
			arriveAt89[num]=true;
			return arriveAt89[num];
		} else {
			if (!checked[num]) { //cache
				checked[num]=true;
				arriveAt89[num]=computeChain(nextChainInt(num));
			}
			return arriveAt89[num];
		}
	}
	
	public static int nextChainInt (int num) {
		int sum=0;
		for (int i=pow10.length-1;i>=0;i--) {
			int quotient=num/pow10[i];
			sum+=quotient*quotient;
			num-=(quotient*pow10[i]);
		}
		return sum;
	}
	
	public static void main (String[] args) {
		long before=System.currentTimeMillis();
		computePow10();
		for (int i=1;i<10000000;i++) {
			computeChain(i);
		}
		int count=0;
		for (int i=1;i<10000000;i++) {
			if (arriveAt89[i]) {
				count++;
			}
		}
		long after=System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Used "+(after-before)+"ms.");
	}
	
}