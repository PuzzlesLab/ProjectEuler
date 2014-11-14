public class euler {
	
	public static void main (String[] zzz) {
		int [] power5=new int [10];
		for (int i=1;i<10;i++) {
			power5[i]=(int)Math.pow(i,5);
		}
		int total=0;
		for (int i=2;i<=295245;i++) {
			int num=i;
			int [] digits=new int [6];
			for (int i2=5;i2>=0;i2--) {
				digits[i2]=power5[num/(int)Math.pow(10,i2)];
				num=num%(int)Math.pow(10,i2);
			}
			int sum=digits[0]+digits[1]+digits[2]+digits[3]+digits[4]+digits[5];
			if (sum==i) {
				total+=i;
			}
		}
		System.out.println(total);
	}
	
}