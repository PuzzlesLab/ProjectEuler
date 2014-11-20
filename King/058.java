public class euler {
    
	public static boolean isPrime (int num) {
		if (num==2) {
			return true;
		} else if (num<2 || num%2==0) {
			return false;
		}
		for (int i=3;i*i<=num;i+=2) {
			if (num%i==0) {
				return false;
			}
		}
		return true;
	}
    public static void main(String [] args) throws Exception {
    	int curr=1;
    	double primeCount=0;
    	double totalCount=0;
    	int increment=2;
    	
    	do {
    		for (int i=0;i<4;i++) {
    			if (isPrime(curr)) {
    				primeCount++;
    			}
    			totalCount++;
    			curr+=increment;
    		}
    		increment+=2;
    	} while ((primeCount/totalCount)>=0.10 && (primeCount/totalCount)!=0.0);
    	System.out.println(increment-3);
    }
}