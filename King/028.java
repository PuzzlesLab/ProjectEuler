public class euler {

	public static void main (String[] zzz) {
		int sum=1;
		int size=1001;
		int count=1;
		for (int i=1;i<size/2+1;i++) {
			for (int i2=0;i2<4;i2++) {
				count=count+i*2;
				sum+=count;
			}
		}
		//Add 2 for 4 times, 4 for 4 times, 6 for 4 times, vice versa...
		System.out.println(sum);
	}
	
}