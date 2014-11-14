/*
 * If we took coin with value n earlier, we shall not take coin with more than n.
 * This is to prevent looping through the same combination again
 * as the sequence doesn't matter here.
 * The 100,50,50 is same with 50,50,100.
 * 
 * 
 * aka DFS with branch cutting.
 */

public class euler {
	
	public static int [] coinType={1,2,5,10,20,50,100,200};

	public static int dfs (int sum, int lastPut) {
		if (sum==0) {
			return 1;
		} else {
			int count=0;
			for (int i=coinType.length-1;i>=0;i--) {
				if (lastPut>=i && sum>=coinType[i]) {
					count+=dfs(sum-coinType[i],i);
				}
			}
			return count;
		}
	}
	
	public static void main (String [] abc) {
		System.out.println(dfs(200,coinType.length-1));
	}
}