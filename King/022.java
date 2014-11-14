import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class test {
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("p022_names.txt"));
		String [] s=br.readLine().split(",");
		int count=0;
		Arrays.sort(s);
		for (int i=0;i<s.length;i++) {
			int currCount=0;
			for (int i2=1;i2<s[i].length()-1;i2++) {
				currCount=currCount+(s[i].charAt(i2)-'A'+1);
			}
			currCount=currCount*(i+1);
			count=count+currCount;
		}
		System.out.println(count);
	}
}