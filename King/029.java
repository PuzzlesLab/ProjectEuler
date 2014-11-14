public class euler {
	
	public static void main (String[] zzz) {
		double [] d=new double [99*99+1];
		int dCount=0;
		for (int i=2;i<=100;i++) {
			for (int i2=2;i2<=100;i2++) {
				double v=Math.pow(i,i2);
				boolean found=false;
				for (int di=0;di<dCount;di++) {
					if (d[di]==v) {
						found=true;
						break;
					}
				}
				if (!found) {
					d[dCount++]=v;
				}
			}
		}
		System.out.println(dCount);
	}
	
}