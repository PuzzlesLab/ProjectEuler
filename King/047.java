public class euler {

	public static int distinctPrimeFactorsCount (int num) {
		int factorCount=0;
		for (int factor=2;factor*factor<=num;factor++) {
			if (num%factor==0) {
				factorCount++;
				while (num%factor==0) {
					num=num/factor;
				}
			}
		}
		return (factorCount+1); //1 for the remaining prime factor.
	}
	
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		int consecutiveCount=0;
		int answerPlus3=0;
		for (int i=647;consecutiveCount<4;i++) {
			if (distinctPrimeFactorsCount(i)==4) {
				consecutiveCount++;
				answerPlus3=i;
			} else {
				consecutiveCount=0;
			}
		}
		System.out.println(answerPlus3-3);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}