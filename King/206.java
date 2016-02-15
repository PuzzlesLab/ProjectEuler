
public class Euler {
	
	public static int [] table={0,9,8,7,6,5,4,3,2,1};
	
	public static boolean check(long l) {
		int matchCount=0;
		int remainder=(int)l%10;
		l=l/10;
		if (remainder==table[0]) {
			matchCount++;
		}
		if (matchCount==1) {
			for (int i=0;i<table.length-1;i++) {
				if ((l%100)/10==table[i+1]) {
					matchCount++;
					l/=100;
				} else {
					break;
				}
			}
		} 
		return matchCount==table.length;
	}
	
	public static void main (String [] args) {
		//1_2_3_4_5_6_7_8_9_0 => 19 digits
		//min digits = 19/2 + 1 = 9 digits
		//the last digit should be 0...
		//The maximum number should be square root of 192939495969798990.
		//The min number should be square root of 1020304050607080990
		long start = System.currentTimeMillis();
		long min = (long)Math.sqrt(1020304050607080900L);
		long max = (long)Math.sqrt(1929394959697989990L);
		for (;min<=max;min+=10) {
			if (check(min*min)) {
				System.out.println(min);
				break;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Took "+(end-start)+" ms.");
	}
}
