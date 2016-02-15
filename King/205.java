import java.math.BigDecimal;
import java.math.MathContext;

public class euler {
	
	private static int [][] pyramidalDP = new int [10][37];
	private static int [][] cubicDP = new int [7][37];
	
	public static void main (String [] args) {
		long startTime=System.currentTimeMillis();
		//Dynamic Programming
		//number of ways[diceCount][sum] = number of ways[diceCount-1][sum-1...4]
		pyramidalDP[0][0]=1;
		for (int diceCount=1;diceCount<pyramidalDP.length;diceCount++) {
			pyramidalDP[diceCount][diceCount]=1;
			for (int sum=diceCount+1;sum<=4*diceCount;sum++) {
				for (int value=1;value<=4 && value<=sum;value++) {
					pyramidalDP[diceCount][sum]+=pyramidalDP[diceCount-1][sum-value];
				}
			}
		}
		
		int [] culmulativePyramidal=new int [pyramidalDP[0].length];
		for (int i=1;i<culmulativePyramidal.length;i++) {
			culmulativePyramidal[i]=culmulativePyramidal[i-1]+pyramidalDP[pyramidalDP.length-1][i];
		}
		
		//Dynamic Programming
		//number of ways[diceCount][sum] = number of ways[diceCount-1][sum-1...6]
		cubicDP[0][0]=1;
		for (int diceCount=1;diceCount<cubicDP.length;diceCount++) {
			cubicDP[diceCount][diceCount]=1;
			for (int sum=diceCount+1;sum<=6*diceCount;sum++) {
				for (int value=1;value<=6 && value<=sum;value++) {
					cubicDP[diceCount][sum]+=cubicDP[diceCount-1][sum-value];
				}
			}
		}
		
		int [] culmulativeCubic=new int [cubicDP[0].length];
		for (int i=1;i<culmulativeCubic.length;i++) {
			culmulativeCubic[i]=culmulativeCubic[i-1]+cubicDP[cubicDP.length-1][i];
		}
		
		BigDecimal chance=BigDecimal.ZERO;
		MathContext mc=new MathContext(7);
		for (int i=9;i<=36;i++) {
			BigDecimal pyramidalCount = BigDecimal.valueOf(pyramidalDP[pyramidalDP.length-1][i]);
			BigDecimal pyramidalChance = pyramidalCount.divide(BigDecimal.valueOf(culmulativePyramidal[culmulativePyramidal.length-1]), mc);
			
			BigDecimal cubicCulCount = BigDecimal.valueOf(culmulativeCubic[i-1]);
			BigDecimal cubicCulChance = cubicCulCount.divide(BigDecimal.valueOf(culmulativeCubic[culmulativeCubic.length-1]), mc);
			
			chance=chance.add(pyramidalChance.multiply(cubicCulChance, mc));
			//f(n) : Chance to get n in pyramidal x Chance to get (n-1.....0) in cubic
		}

		System.out.println(chance.round(mc).toString());
		long endTime=System.currentTimeMillis();
		System.out.println("Took "+(endTime-startTime)+" ms.");
	}
	
}
