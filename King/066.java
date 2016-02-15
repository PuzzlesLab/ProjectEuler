import java.math.BigInteger;

public class euler2 {

	
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		BigInteger [] minX=new BigInteger [1001];
		for (int d=1;d<minX.length;d++) {
			double sqrt=Math.sqrt(d);
			
			if (sqrt!=(double)(int)sqrt) {
				// PQa algorithm : http://mathafou.free.fr/themes_en/kpell.html
				BigInteger U=BigInteger.ZERO;
				BigInteger V=BigInteger.ONE;
				BigInteger a0=BigInteger.valueOf((long)Math.sqrt(d));
				BigInteger P=a0;
				BigInteger Q=BigInteger.ONE;
				BigInteger PminusOne=BigInteger.ONE;
				BigInteger QminusOne=BigInteger.ZERO;
				BigInteger a=a0;
				BigInteger D=BigInteger.valueOf(d);
				
				int k=0;
				do {
					U=a.multiply(V).subtract(U);
					V=D.subtract(U.multiply(U)).divide(V);
					a=a0.add(U).divide(V);
					
					BigInteger Ptemp=P;
					BigInteger Qtemp=Q;
					
					P=a.multiply(P).add(PminusOne);
					Q=a.multiply(Q).add(QminusOne);
					
					PminusOne=Ptemp;
					QminusOne=Qtemp;
					
					k++;
				} while (!(a.compareTo(a0)>0 || V.equals(BigInteger.ONE)));
				if (k%2==0) {
					minX[d]=P;
				} else {
					minX[d]=P.multiply(P).add(D.multiply(Q.multiply(Q)));
				}
			} else {
				minX[d]=BigInteger.ZERO;
			}
		}
		
		int maxD=1;
		for (int i=2;i<minX.length;i++) {
			if (minX[i].compareTo(minX[maxD])>0) {
				maxD=i;
			}
		}
		System.out.println(maxD);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}