public class euler {
	
	public static long max=0;
	
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
	
	//Depth limited depth first search. 2^d + 2^(d-1) + ...
	//Worst case complexity = 2^9 + 2^8 + 2^7 + .... 2^1
	public static void dfs (long lastValue, boolean [] intSet, int currDepth, int maxDepth) {
		if (currDepth==maxDepth) {
			if (isPrime(lastValue)) {
				max=lastValue;
			}
		} else if (max==0) {
			long newValue=lastValue*10;
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
		for (int depth=9;depth>=1 && max==0;depth--) {
			for (int starting=depth;starting>=1 && max==0;starting--) {
				boolean [] flag=new boolean [10];
				flag[starting]=true;
				dfs(starting,flag,1,depth);
			}
		}
		System.out.println(max);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
} 