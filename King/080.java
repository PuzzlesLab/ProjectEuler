package euler;

import java.math.BigDecimal;
import java.math.MathContext;

public class euler {
	
	//first hundred natural numbers = 99
	public static boolean [] isPrefectSquare = new boolean [100];
	public static BigDecimal [] squareRoot=new BigDecimal [100];
	
	public static BigDecimal getSquareRoot (double d) {
		//Newton raphson
		BigDecimal xN=BigDecimal.valueOf(d);
		BigDecimal xNMinusOne=BigDecimal.ZERO;
		MathContext mc=new MathContext(105);
		BigDecimal bdd=BigDecimal.valueOf(d);
		BigDecimal half=BigDecimal.valueOf(0.5);
		while (true) {
			xNMinusOne=xN;
			xN=half.multiply(xNMinusOne.add(bdd.divide(xNMinusOne,mc)),mc);
			if (xNMinusOne.equals(xN)) {
				break;
			}
		}
		return xN.setScale(99,BigDecimal.ROUND_DOWN);
	}
	
	public static int calculateSumOfDigits (BigDecimal d) {
		String s=d.toString();
		char [] c=s.toCharArray();
		int sum=0;
		for (int i=0;i<c.length;i++) {
			sum+=(c[i]-'0'); //add all in ascii.
		}
		sum-=('.'-'0'); //remove the dot.
		return sum;
	}
	
	public static void main (String[] args) {
		long before=System.currentTimeMillis();
		for (int i=0;i<10;i++) { //10^2 = 100.
			isPrefectSquare[i*i]=true;
		}
		for (int i=0;i<100;i++) {
			if (!isPrefectSquare[i]) {
				squareRoot[i]=getSquareRoot(i);
			}
		}
		int sum=0;
		for (int i=0;i<100;i++) {
			if (!isPrefectSquare[i]) {
				sum+=calculateSumOfDigits(squareRoot[i]);
			}
		}
		long after=System.currentTimeMillis();
		System.out.println(sum);
		System.out.println("Took "+(after-before)+" ms.");
	}
	
}