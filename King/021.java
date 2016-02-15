public class euler {
	
	private static int divisorsSum (int num) {
		if (num==1) {
			return 0;
		} else {
			int count=1; //1.
			for (int i=2;i*i<num;i++) {
				if (num%i==0) {
					count+=(i+num/i);
				}
			}
			int sqrt=(int) Math.sqrt(num);
			if (sqrt*sqrt==num) {
				count+=sqrt;
			}
			return count;
		}
	}
	
	public static void main (String [] abc) {
		boolean [] found=new boolean [10000];
		int sum=0;
		for (int i=2;i<10000;i++) {
			if (!found[i]) {
				found[i]=true;
				int dSum=divisorsSum(i);
				int dSum2=divisorsSum(dSum);
				if (dSum2==i && dSum<10000 && dSum!=i) {
					sum+=(i+dSum);
					found[dSum]=true;
				}
			}
		}
		System.out.println(sum);
	}
}