package euler;

import java.io.BufferedReader;
import java.io.FileReader;

public class euler {

	public static void main (String [] zzzz) throws Exception {
		long before=System.currentTimeMillis();
		BufferedReader br=new BufferedReader(new FileReader("C:\\users\\king\\desktop\\p079_keylog.txt"));
		int [][] reply=new int [50][3];
		for (int i=0;i<50;i++) {
			int number=Integer.parseInt(br.readLine());
			for (int i2=2;i2>=0;i2--) {
				reply[i][i2]=number%10;
				number/=10;
			}
		}
		// question : shortest, therefore i assume the digits don't repeat... :D
		boolean [][] existsBefore=new boolean [10][10];
		boolean [] candidates=new boolean [10];
		for (int i=0;i<50;i++) {
			int n0=reply[i][0];
			int n1=reply[i][1];
			int n2=reply[i][2];
			existsBefore[n0][n1]=true;
			existsBefore[n1][n2]=true;
			candidates[n0]=true;
			candidates[n1]=true;
			candidates[n2]=true;
		}
		int candidateCount=0;
		for (int i=0;i<10;i++) {
			if (candidates[i]) {
				candidateCount++;
			}
		}
		String answer="";
		// search for the next digit that doesn't has other candidate digits in front of it.
		for (int i=0;i<10 && candidateCount>0;i++) {
			if (candidates[i]) {
				boolean comesNext=true;
				for (int i2=0;i2<10;i2++) {
					if (candidates[i2]) {
						if (existsBefore[i2][i]) {
							comesNext=false;
							break;
						}
					}
				}
				if (comesNext) {
					answer=answer+i;
					candidates[i]=false;
					candidateCount--;
					//Found, add it to answer.
					i=-1;
					//reset the search again.
				}
			}
		}
		System.out.println(answer);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}