public class euler {
	
	public static boolean validate (long num) {
		for (int i=0;i<50;i++) {
			long toTestNum=num;
			long reverseNum=0;
			while (toTestNum>0) {
				reverseNum=reverseNum*10+toTestNum%10;
				toTestNum/=10;
			}
			long sum=num+reverseNum;
			long toTestSum=sum;
			long reverseSum=0;
			while (toTestSum>0) {
				reverseSum=reverseSum*10+toTestSum%10;
				toTestSum/=10;
			}
			if (sum==reverseSum) {
				return true;
			} else {
				num=sum;
			}
		}
		return false;
	}
	
	public static void main (String [] args) {
		double before=System.currentTimeMillis();
		int count=0;
		for (int i=1;i<10000;i++) {
			if (!validate(i)) {
				count++;
			}
		}
		System.out.println(count);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}