package euler;

import java.math.BigInteger;

public class euler {

	public static class Fraction {
		BigInteger numerator;
		BigInteger denominator;
		
		public Fraction () {}
		
		public Fraction (BigInteger n, BigInteger d) {
			this.numerator=n;
			this.denominator=d;
		}
		
		public Fraction add (Fraction f) {
			BigInteger lcm=this.denominator.multiply(f.denominator).divide(this.denominator.gcd(f.denominator));
			Fraction newF=new Fraction();
			newF.numerator=lcm.divide(this.denominator).multiply(this.numerator).add(lcm.divide(f.denominator).multiply(f.numerator));
			newF.denominator=lcm;
			return newF;
		}
		
		public Fraction invert () {
			Fraction newF=new Fraction();
			newF.numerator=this.denominator;
			newF.denominator=this.numerator;
			return newF;
		}
	}
	
	//e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].
	
	public static int getA (int depth) {
		if (depth==0) {
			return 2;
		} else if (depth%3==2) {
			return 2*((depth/3)+1);
		} else {
			return 1; 
		}
	}
	
	public static int max=0;
	
	public static Fraction expandHelper (int depth) {
		if (depth==max) {
			return new Fraction(BigInteger.ONE,BigInteger.valueOf(getA(depth)));
		} else {
			Fraction ex=expandHelper(depth+1);
			return new Fraction(BigInteger.valueOf(getA(depth)),BigInteger.ONE).add(ex).invert();
		}
	}
	
	public static Fraction expand (int maxDepth) {
		max=maxDepth-1;
		return expandHelper(0).invert();
	}
	
	public static void main (String [] zzzz) {
		long before=System.currentTimeMillis();
		Fraction result=expand(100);
		BigInteger numerator=result.numerator;
		BigInteger sum=BigInteger.ZERO;
		while (!numerator.equals(BigInteger.ZERO)) {
			sum=sum.add(numerator.mod(BigInteger.TEN));
			numerator=numerator.divide(BigInteger.TEN);
		}
		System.out.println(sum.toString());
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}