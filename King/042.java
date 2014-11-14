import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class euler {
	
	/*
		2T=n^2 + n
		n^2 + n - 2T = 0
		n = [-b+-sqrt(b^2 - 4ac)] / 2a
		a=1, b=1, c=-2T
		n = [-1+-sqrt(1-4(-2T))]/2
		n = [-1+sqrt(1+8T)]/2
		
		if 1+8T is a prefect square, then T is a triangle number.
	 */
	
	public static boolean isTriangleNumbers (int t) {
		double sqrt=Math.sqrt(1+8*t);
		return (sqrt==(double)(int)(sqrt));
	}
	
	public static void main (String [] args) throws IOException {
		long before=System.currentTimeMillis();
		BufferedReader br=new BufferedReader(new FileReader("p042_words.txt"));
		String [] names=br.readLine().split(",");
		int count=0;
		for (int i=0;i<names.length;i++) {
			names[i]=names[i].substring(1,names[i].length()-1);
		}
		for (int i=0;i<names.length;i++) {
			int sum=0;
			for (int i2=0;i2<names[i].length();i2++) {
				sum+=(names[i].charAt(i2)-'A'+1);
			}
			if (isTriangleNumbers(sum)) {
				count++;
			}
		}
		System.out.println(count);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
} 