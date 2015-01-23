package euler;

public class euler {
	
	/* ===========
	 * Result (nth power - found)
	 * ===========
	 * 1 - 0
		2 - 9
		3 - 15
		4 - 20
		5 - 24
		6 - 27
		7 - 30
		8 - 32
		9 - 34
		10 - 36
		11 - 38
		12 - 39
		13 - 40
		14 - 41
		15 - 42
		16 - 43
		17 - 44
		18 - 45
		19 - 46
		20 - 47
		21 - 48
		22 - 49
		23 - 49
		24 - 49
		25 - 49
		26 - 49
		27 - 49
		28 - 49
		29 - 49
		30 - 49
		31 - 49
		32 - 49
		33 - 49
		34 - 49
		35 - 49
		36 - 49
		37 - 49
		38 - 49
		39 - 49
		40 - 49
		41 - 49
		42 - 49
		43 - 49
		44 - 49
		45 - 49
		46 - 49
		47 - 49
		48 - 49
		49 - 49

	 */
	public static void main (String [] zzzz) {
		long before=System.currentTimeMillis();
		int n=50;
		int count=0;
		for (int i=1;i<10;i++) { //cos 10^something > more than digits itself.
			for (int i2=1;i2<n;i2++) {
				int digitsCount=(int)Math.log10(Math.pow(i,i2))+1;
				if (digitsCount==i2) {
					count++;
				} else if (digitsCount>i2) { //more than n digit, needness to continue as the number will become bigger.
					break;
				}
			}
		}
		System.out.println(count);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}
