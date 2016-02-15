package euler2;

import java.math.BigDecimal;
import java.math.MathContext;

public class euler2 {

	public static BigDecimal [] fractorial = new BigDecimal [71];
	
	public static void calcFractorial () {
		fractorial[0]=BigDecimal.ONE;
		for (int i=1;i<fractorial.length;i++) {
			fractorial[i]=fractorial[i-1].multiply(BigDecimal.valueOf(i));
		}
	}
	
	public static BigDecimal nCr (int n, int r) {
		BigDecimal value = fractorial[n].divide(fractorial[n-r].multiply(fractorial[r]));
		return value;
	}
	
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		//Chance to have distinct colors = 7 colors x (1 - Chance to miss out one color)
		//Chance to miss out one colour = 60C20 / 70C20
		calcFractorial();
		BigDecimal chanceToMissOutOneColor=nCr(60,20).divide(nCr(70,20),new MathContext(10));
		BigDecimal result=BigDecimal.valueOf(7).multiply(BigDecimal.ONE.subtract(chanceToMissOutOneColor));
		result=result.setScale(9, BigDecimal.ROUND_HALF_UP);
		System.out.println(result.toString());
		long after=System.currentTimeMillis();
		System.out.println("Took "+(after-before)+" ms.");
	}
	
}
