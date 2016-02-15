public class euler {
	
	public static int [] divisor={2,3,5,7,11,13,17};
	public static long sum=0;
	
	//depth first search.
	public static void dfs (int [] digits, boolean [] flag, int digitsCount) {
		if (digitsCount==9) {
			long num=0;
			for (int i=0;i<10;i++) {
				num=num*10+digits[i];
			}
			sum+=num;
		} else {
			digitsCount++;
			if (digitsCount<3) {
				for (int i=0;i<10;i++) {
					if (!flag[i]) {
						flag[i]=true;
						digits[digitsCount]=i;
						dfs(digits,flag,digitsCount);
						flag[i]=false;
					}
				}
			} else {
				int currentPartialSum=digits[digitsCount-2]*100+digits[digitsCount-1]*10;
				for (int i=0;i<10;i++) {
					//if number is not used + current digits satisfy requirement
					if (!flag[i] && (currentPartialSum+i)%divisor[digitsCount-3]==0) {
						flag[i]=true;
						digits[digitsCount]=i;
						dfs(digits,flag,digitsCount);
						flag[i]=false;
					}
				}
			}
		}
	}
	
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		boolean [] flag=new boolean[10];
		int [] digits=new int [10];
		dfs(digits,flag,0);
		System.out.println(sum);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}