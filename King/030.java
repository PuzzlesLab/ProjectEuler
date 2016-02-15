public class euler {
	
	public static void main (String[] zzz) {
		long lel=System.currentTimeMillis();
		int [] power5=new int [10];
		for (int i=1;i<10;i++) {
			power5[i]=i*i*i*i*i;
		}
		int total=0;
		for (int i=2;i<=6*power5[9];i++) {
			int num=i;
			int sum=0;
			while (num>0) {
				sum+=power5[num%10];
				num/=10;
			}
			if (sum==i) {
				total+=i;
			}
		}
		System.out.println(total);
		long lel2=System.currentTimeMillis();
		System.out.println(lel2-lel);
	}
	
}