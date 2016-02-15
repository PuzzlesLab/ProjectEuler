public class euler {
	
	public static int max=0;
	
	public static boolean isPrime (long v) {
		if (v==2 || v==3 || v==5) {
			return true;
		} else if (v%2==0) {
			return false;
		}
		for (long i=3;i*i<=v;i+=2) {
			if (v%i==0) {
				return false;
			}
		}
		return true;
	}
	
	//Depth limited depth first search.
	//Worst case complexity = 9! + 8! + 7! + ...
	public static void dfs (int lastValue, boolean [] intSet, int currDepth, int maxDepth) {
		if (currDepth==maxDepth) {
			//System.out.println(lastValue);
			if (isPrime(lastValue)) {
				max=lastValue;
			}
		} else if (max==0) {
			int newValue=lastValue*10;
			for (int i=maxDepth;i>0;i--) {
				if (!intSet[i]) {
					intSet[i]=true;
					dfs(newValue+i,intSet,currDepth+1,maxDepth);
					intSet[i]=false;
				}
			}
		}
	}
	
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		for (int depth=9;depth>=3 && max==0;depth--) {
			dfs(0,new boolean [10],0,depth);
		}
		System.out.println(max);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
	
} 