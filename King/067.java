package euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class euler {
	
	public static int SIZE=100;
	
	public static void main (String [] zzzz) throws Exception {
		long before=System.currentTimeMillis();
		BufferedReader br=new BufferedReader(new FileReader("C:\\users\\king\\desktop\\p067_triangle.txt"));
		int [][] numbers=new int [SIZE][SIZE];
		for (int i=0;i<SIZE;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int i2=0;i2<=i;i2++) {
				numbers[i][i2]=Integer.parseInt(st.nextToken());
			}
		}
		int [] result=new int [SIZE];
		for (int i=0;i<SIZE;i++) {
			result[i]=numbers[SIZE-1][i];
		}
		for (int i=SIZE-2;i>=0;i--) {
			for (int i2=0;i2<i+1;i2++) {
				result[i2]=Math.max(result[i2],result[i2+1])+numbers[i][i2];
			}
		}
		System.out.println(result[0]);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}