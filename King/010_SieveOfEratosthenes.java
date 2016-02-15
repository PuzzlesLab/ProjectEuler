public class euler {

	public static void main (String[] abc) {
		long before=System.currentTimeMillis();
		boolean [] flag=new boolean [2000000];
		for (int i=2;i*i<flag.length;i++) {
			if (!flag[i]) {
				for (int i2=i*i;i2<flag.length;i2+=i) {
					flag[i2]=true;
				}
			}
		}
		long sum=0;
		for (int i=2;i<flag.length;i++) {
			if (!flag[i]) {
				sum+=i;
			}
		}
		long after=System.currentTimeMillis();
		System.out.println(sum);
		System.out.println("Time taken : "+(after-before)+"ms.");
	}

}