import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Euler {
	
	public static void main (String [] args) throws IOException {
		long before=System.currentTimeMillis();
		BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\king8\\Desktop\\p099_base_exp.txt"));
		int lineNo=-1;
		double max=0.0;
		for (int i=1;i<=1000;i++) {
			String [] s=br.readLine().split(",");
			int base=Integer.parseInt(s[0]);
			int exp=Integer.parseInt(s[1]);
			double value=exp*Math.log(base);
			if (value>max) {
				max=value;
				lineNo=i;
			}
		}
		br.close();
		long after=System.currentTimeMillis();
		System.out.println(lineNo);
		System.out.println("Took "+(after-before)+" ms.");
	}
}
