public class euler {
	
	public static void main (String [] abc) {
		int total=0;
		int last2=1;
		int last=1;
		int f=0;
		while (last<4000000) {
			f=last+last2;
			if (f%2==0) {
				total+=f;
			}
			last2=last;
			last=f;
		}
		System.out.println(total);
	}
	
}