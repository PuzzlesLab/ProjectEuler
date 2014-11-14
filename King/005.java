public class euler {
	
	public static void main (String [] zzz) {
		for (int i=20;true;i++) {
			boolean failed=false;
			for (int i2=1;i2<=20;i2++) {
				if (i%i2!=0) {
					failed=true;
					break;
				}
			}
			if (!failed) {
				System.out.println(i);
				break;
			}
		}
	}
}