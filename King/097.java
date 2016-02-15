public class Euler {
	
	public static void main (String [] args) throws IOException {
		long before=System.currentTimeMillis();
		long value=1;
		long tenPowTen=10000000000L;
		//7830456 + 1 = 2 x 3915228 + 1
		for (int i=0;i<3915228;i++) {
			value=(value*4)%tenPowTen;
		}
		value=value*2;
		value=(value*28433+1)%tenPowTen;
		long after=System.currentTimeMillis();
		System.out.println(value);
		System.out.println("Took "+(after-before)+" ms.");
	}
}
