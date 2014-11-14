public class euler {
	
	public static int [] fractorial = new int [10];
	
	public static void main (String [] abc) {
		long before=System.currentTimeMillis();
		int totalSum=0;
		fractorial[0]=1;
		for (int i=1;i<10;i++) {
			fractorial[i]=fractorial[i-1]*i;
		}
		int bound=fractorial[9]*7;
		for (int i=3;i<=bound;i++) {
			int sum=0;
			int test=i;
			while (test>0) {
				sum+=fractorial[test%10];
				test/=10;
			}
			if (sum==i) {
				totalSum+=i;
			}
		}
		System.out.println(totalSum);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}