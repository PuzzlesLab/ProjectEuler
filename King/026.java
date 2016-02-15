public class euler {

	public static void main (String [] zz) {
		int max=1;
		int d=-1;
		for (int i=7;i<1000;i++) {
			int [] remainderOccurance=new int [i];
			int place=0;
			int remainder=1;
			
			for (;remainder!=0 && remainderOccurance[remainder]==0;place++) {
				remainderOccurance[remainder]=place;
				remainder=(remainder*10)%i;
				//remainder=0, the fraction is divide completely.
				//remainder repeats, means the sequence is repeated!
			}

			int length=place-remainderOccurance[remainder];
			if (length>max) {
				max=length;
				d=i;
			}
		}
		System.out.println("d="+d);
	}
}