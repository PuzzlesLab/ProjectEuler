public class euler {
	
	/* ============Triangle Numbers==============
	 * 2T = n^2 + n
	 * n^2 + n - 2T = 0
	 * n = [-1+sqrt(1+8T)]/2
	 * if n is int, then n is triangle numbers.
	 * 
	 * ============Pentagonal Numbers==============
	 * 2P = 3n^2 - n
	 * 3n^2 - n - 2P = 0
	 * n = [1+sqrt(1+24P)] / 6
	 * if n is int, then n is pentagonal numbers.
	 * 
	 * ============Hexagonal Numbers==============
	 * H = 2n^2 - n
	 * 2n^2 - n - H = 0
	 * n = [1+sqrt(1+8H)]/4
	 * if n is int, then n is hexagonal numbers.
	 * 
	 * H(n) = 2n^2 - n
	 * H(n-1) = 2(n-1)^2 - (n-1)
	 * 
	 * H(n) - H(n-1) = 2n^2 - n - [2(n^2-2n+1) - n + 1]
	 *               = 2n^2 - n - (2n^2 - 4n + 2 - n + 1)
	 *               = 2n^2 - n - 2n^2 + 4n - 2 + n -1
	 *               = 4n -2 -1
	 *               = 4n - 3
	 */
	
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		long n=144;// H(143) = 40755
		long lastH=40755;
		for (;true;n++) {
			lastH+=(4*n-3);
			double triangleN=(-1+Math.sqrt(1+8*lastH))/2;
			double pentagonalN=(1+Math.sqrt(1+24*lastH))/6;
			if (triangleN==(int)triangleN && pentagonalN==(int)pentagonalN) {
				break;
			}
		}
		System.out.println(lastH);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
} 