public class euler {
	
	public static int getAmicableNumber (int num) {
		int count=0;
		for (int i=1;i<num;i++) {
			if (num%i==0) {
				count+=i;
			}
		}
		return count;
	}
	
	public static void main (String [] abc) {
		int total=0;
		for (int i=1;i<10000;i++) {
			int b=getAmicableNumber(i);
			if (b<10000 && b!=i && getAmicableNumber(b)==i) {
				total=total+i;
			}
		}
		System.out.println(total);
	}
}