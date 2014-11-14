public class euler {
	
	public static int [] dp=new int [1000001];
	
	public static void main (String [] abc) {
		int maxStartingNum=0;
		long maxChain=0;
		dp[1]=1;
		for (int i=1;i<1000001;i++) {
			long number=i;
			int currChain=1;
			while (true) {
				if (number<=1000000 && dp[(int)number]!=0) {
					currChain+=dp[(int)number];
					break;
				}
				if (number%2==0) {
					number=number/2;
				} else {
					number=3*number+1;
				}
				currChain++;
			}
			dp[i]=currChain;
			if (currChain>maxChain) {
				maxChain=currChain;
				maxStartingNum=i;
			}
		}
		System.out.println(maxStartingNum);
	}
}