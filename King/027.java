public class euler {

	public static void main (String[] zzz) {
		long a=System.currentTimeMillis();
		int sum=1;
		int size=1001;
		int [] firstTermInSpin = new int [size/2+1];
		firstTermInSpin[0]=1;
		for (int i=1;i<firstTermInSpin.length;i++) {
			firstTermInSpin[i]=firstTermInSpin[i-1]+2+8*(i-1);
			sum=sum+4*(firstTermInSpin[i]+3*i);
		}
		System.out.println(sum);
		long b=System.currentTimeMillis();
		System.out.println(b-a);
	}
	
}