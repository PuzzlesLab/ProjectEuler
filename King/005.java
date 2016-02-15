public class euler {	
	public static void main (String [] zzz) {
		long before=System.currentTimeMillis();
		//Get lcm of non prime numbers
		int [] nonPrimeNum={12,14,15,16,18,20};
		int nonPrimeLcm=0;
		boolean flag=false;
		for (int i=0;nonPrimeLcm==0;i+=nonPrimeNum[nonPrimeNum.length-1]) {
			flag=true;
			for (int i2=nonPrimeNum.length-2;i2>=0 && flag;i2--) {
				flag=i%nonPrimeNum[i2]==0;
			}
			if (flag) {
				nonPrimeLcm=i;
			}
		}
		
		int step=11*13*17*19; //lcm of prime numbers.

		int number=step; 
		for (;number%nonPrimeLcm!=0;number+=step) {} //search multiples of lcm of prime numbers.
		long after=System.currentTimeMillis();
		System.out.println(number);
		System.out.println("Time taken : "+(after-before)+" ms");
	}
}