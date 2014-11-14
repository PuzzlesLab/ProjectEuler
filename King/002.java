public class euler {
	
	public static int [] f=new int [100000];
	
	public static int getF (int i) {
		if (i<=0) {
			return 1;
		}
		if (f[i]==0) {
			f[i]=getF(i-1)+getF(i-2);
		}
		return f[i];
	}
	
	public static void main (String [] abc) {
		int total=0;
		f[1]=1;
		for (int i=1;true;i++) {
			if (getF(i)<4000000) {
				if (getF(i)%2==0) {
					total+=getF(i);
				}
			} else {
				break;
			}
		}
		System.out.println(total);
	}
	
}