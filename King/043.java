public class euler {
	
	public static int [] divisor={2,3,5,7,11,13,17};
	public static long sum=0;
	
	public static boolean hasSubstringDivisibility (int [] digits) {
		for (int i=1;i<=7;i++) {;
			int substring=digits[i]*100+digits[i+1]*10+digits[i+2];
			if (substring%divisor[i-1]!=0) {
				return false;
			}
		}
		return true;
	}
	
	//depth limited depth first search.
	public static void dfs (int [] digits, boolean [] flag, int digitsCount) {
		if (digitsCount==9) {
			if (hasSubstringDivisibility(digits)) {
				long num=0;
				for (int i=0;i<10;i++) {
					num=num*10+digits[i];
				}
				sum+=num;
			}
		} else {
			digitsCount++;
			for (int i=0;i<10;i++) {
				if (!flag[i]) {
					flag[i]=true;
					digits[digitsCount]=i;
					dfs(digits,flag,digitsCount);
					flag[i]=false;
				}
			}
		}
	}
	
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		for (int i=0;i<10;i++) {
			boolean [] flag=new boolean[10];
			int [] digits=new int [10];
			flag[i]=true;
			digits[0]=i;
			dfs(digits,flag,0);
		}
		System.out.println(sum);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
} 