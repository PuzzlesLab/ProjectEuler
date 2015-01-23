package euler;

import java.math.BigInteger;

public class euler {
	
	public static class Fraction {
		BigInteger numerator;
		BigInteger denominator;
		
		public Fraction() {}
		
		public Fraction(BigInteger n, BigInteger d) {
			this.numerator=n;
			this.denominator=d;
		}
		
		public Fraction add(Fraction f) {
			BigInteger lcm=this.denominator.multiply(f.denominator).divide(this.denominator.gcd(f.denominator));
			Fraction newF=new Fraction();
			newF.numerator=this.numerator.multiply(lcm.divide(this.denominator)).add(f.numerator.multiply(lcm.divide(f.denominator)));
			newF.denominator=lcm;
			return newF;
		}
		
		public Fraction divide(Fraction f) {
			Fraction newF=new Fraction();
			newF.numerator=this.numerator.multiply(f.denominator);
			newF.denominator=this.denominator.multiply(f.numerator);
			BigInteger hcf=newF.numerator.gcd(newF.denominator);
			newF.numerator=newF.numerator.divide(hcf);
			newF.denominator=newF.denominator.divide(hcf);
			return newF;
		}
	}

	public static void main (String [] zzzz) {
		long before=System.currentTimeMillis();
		Fraction ONE=new Fraction(BigInteger.ONE,BigInteger.ONE);
		Fraction lastExpansion=new Fraction(BigInteger.valueOf(3),BigInteger.valueOf(2));
		int count=0;
		for (int i=2;i<=1000;i++) {
			lastExpansion=ONE.add(ONE.divide(ONE.add(lastExpansion)));
			if (lastExpansion.numerator.toString().length()>lastExpansion.denominator.toString().length()) {
				count++;
			}
		}
		System.out.println(count);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}