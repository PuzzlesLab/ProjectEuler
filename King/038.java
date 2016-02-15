public class euler {
	
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		int maxConProd=918273645;
		for (int i=1;i<=9876;i++) {
			int currConProd=0;
			int [] digitOccurance=new int [10];
			int currDigitsCount=0;
			boolean hasDuplicatedDigit=false;
			for (int i2=1;i2<=i && !hasDuplicatedDigit;i2++) {
				int prod=i*i2;
				int prodDigitsCount=(int)Math.log10(prod)+1;
				currDigitsCount=currDigitsCount+prodDigitsCount;
				if (currDigitsCount>9) {
					break;
				}
				currConProd=currConProd*(int)Math.pow(10, prodDigitsCount)+prod;
				while (prod>0) {
					int digit=prod%10;
					if (digit==0 || digitOccurance[digit]>0) {
						hasDuplicatedDigit=true;
						break;
					} else {
						digitOccurance[digit]++;
					}
					prod/=10;
				}
				if (currConProd*(int)Math.pow(10, 9-currDigitsCount)<maxConProd) {
					break;
				}
				if (!hasDuplicatedDigit && currDigitsCount==9) {
					maxConProd=Math.max(currConProd, maxConProd);
				}
			}
		}
		System.out.println(maxConProd);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}