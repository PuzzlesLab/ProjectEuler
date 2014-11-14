public class euler {
	
	public static int isPandigital (String s) {
		boolean [] flag=new boolean [10];
		flag[0]=true;
		int count=0;
		long num=Long.parseLong(s); //s could be too many digits for int.
		while (num>0) {
			if (!flag[(int)(num%10)]) {
				flag[(int)(num%10)]=true;
				count++;
			} else {
				return 0;
			}
			num/=10;
		}
		if (count==9) return 1;
		else return 2;
	}
	
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		String product="";
		for (int i=2;i<=9876;i++) {
			String s="";
			for (int i2=1;i2<=i;i2++) {
				s+=String.valueOf(i*i2);
				int state=isPandigital(s);
				if (state==0) {
					break;
				} else if (state==1) {
					product=s;
					break;
				}
			}
		}
		System.out.println(product);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}