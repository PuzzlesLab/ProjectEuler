public class euler {

	public static void main (String [] args) {
		//https://en.wikipedia.org/wiki/Formulas_for_generating_Pythagorean_triples#Progressions_of_whole_and_fractional_numbers...
		long before=System.currentTimeMillis();
		int [] count=new int [1001];
		for (int i=1;i<33;i++) {
			int b=i*2+1;
			int a=i*b+i;
			int c=(int)Math.sqrt(a*a+b*b);
			for (int multiply=1;multiply<=count.length/(a+b+c);multiply++) {
				count[(a+b+c)*multiply]++;
			}
			
			b=4*i+4;
			a=i*b+(4*i+3);
			c=(int)Math.sqrt(a*a+b*b);
			for (int multiply=1;multiply<=count.length/(a+b+c);multiply++) {
				count[(a+b+c)*multiply]++;
			}
		}
		int countMax=0;
		for (int i=1;i<count.length;i++) {
			if (count[i]>count[countMax]) {
				countMax=i;
			}
		}
		System.out.println(countMax);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}