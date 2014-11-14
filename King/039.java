public class euler {
	
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		int p=1000;
		int [] count=new int [p+1];
		for (int i=3;i<=(p/2)-1;i++) {
			for (int i2=i+1;i2<=(p/2)+1;i2++) {
				int sumSquare=i*i+i2*i2;
				double sqrt=Math.sqrt(sumSquare);
				if (sqrt==(double)(int)sqrt && (i+i2+(int)sqrt<=p)) {
					count[i+i2+(int)sqrt]++;
				}
				if (i+i2+(int)sqrt>=p) {
					break;
				}
			}
		}
		int max=12;
		for (int i=1;i<count.length;i++) {
			if (count[i]>=count[max]) {
				max=i;
			}
		}
		System.out.println(max+", Solutions = "+count[max]);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}