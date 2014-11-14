public class q1 {
	
	public static boolean validate (int x, int check) {
		int digits [][] = new int [check][10];
		for (int i=0;i<check;i++) {
			int num=(i+1)*x;
			while (num>0) {
				digits[i][num%10]++;
				num/=10;
			}
		}
		for (int i=0;i<10;i++) {
			for (int i2=1;i2<check;i2++) {
				if (digits[0][i]!=digits[i2][i]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main (String [] args) {
		double before=System.currentTimeMillis();
		int answer=0;
		for (int i=123456;true;i++) {
			if (validate(i,6)) {
				answer=i;
				break;
			}
		}
		System.out.println(answer);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}