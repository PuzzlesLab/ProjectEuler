public class euler {

	public static boolean [] notPrime;
	
	public static void sieveOfEratothenes (int end) {
		notPrime=new boolean [end+1];
		for (int i=2;i*i<=end;i++) {
			if (!notPrime[i]) {
				for (int i2=i*i;i2<=end;i2+=i) {
					notPrime[i2]=true;
				}
			}
		}
	}
	
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		int maxValue=20000;
		int answer=0;
		sieveOfEratothenes(maxValue);
		for (int i=9;i<=maxValue && answer==0;i+=2) {
			if (notPrime[i]) {
				int sqrt=(int)Math.sqrt(i);
				boolean flag=false;
				for (int i2=1;i2<sqrt;i2++) {
					int num=i-(2*i2*i2);
					if (num>0 && !notPrime[num]) {
						flag=true;
					}
				}
				if (!flag) {
					answer=i;
				}
			}
		}
		System.out.println(answer);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
} 