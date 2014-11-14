public class euler{
	
	public static int numberOfDivisors (int num) {
		int count=0;
		for (int i=1;i*i<num;i++) {
			if (num%i==0) {
				count++;
			}
		}
		count=count*2;
		if ((double)(int)Math.sqrt(num)==Math.sqrt(num)) {
			count++; //num is a prefect square.
		}
		return count;
	}
	
	public static void main (String [] abc) {
		int triangleNum=0;
		for (int i=1;numberOfDivisors(triangleNum)<=500;i++) {
			triangleNum+=i;
		}
		System.out.println(triangleNum);
	}
}