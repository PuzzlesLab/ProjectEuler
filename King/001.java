public class euler {
	
	public static void main (String [] abc) {
		int total=0;
		for (int i=3;i<1000;i+=3) {
			total+=i;
		}
		for (int i=5;i<1000;i+=5) {
			if (i%3!=0) {
				total+=i;
			}
		}
		System.out.println(total);
	}
	
}