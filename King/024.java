import java.math.BigInteger;
import java.util.LinkedList;

public class euler {
	
	public static BigInteger [] fractorial=new BigInteger[11];
	
	public static void main (String [] abc) {
		fractorial[0]=BigInteger.ONE;
		fractorial[1]=BigInteger.ONE;
		for (int i=2;i<11;i++) {
			fractorial[i]=fractorial[i-1].multiply(new BigInteger(String.valueOf(i)));
		}
		
		BigInteger position=new BigInteger("999999"); //because we start from 0th, so 999999 = 1000000th
		String number="";
		LinkedList<Integer> remainingNumbers=new LinkedList<>();
		for (int i=0;i<10;i++) {
			remainingNumbers.addLast(i);
		}
		for (int i=10;i>=1;i--) {
			BigInteger sizePerSegment=fractorial[i].divide(new BigInteger(String.valueOf(i)));
			BigInteger segmentNo=position.divide(sizePerSegment);
			position=position.subtract(segmentNo.multiply(sizePerSegment));
			number=number+remainingNumbers.remove(segmentNo.intValue());
		}
		System.out.println(number.toString());
	}
	
	
}