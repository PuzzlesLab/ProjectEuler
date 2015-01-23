package euler;

import java.util.Arrays;

public class euler {
	
	public static String formatString (long l) {
		char [] c=String.valueOf(l).toCharArray();
		Arrays.sort(c);
		String s="";
		for (int i=0;i<c.length;i++) {
			s=s+c[i];
		}
		return s;
	}
	
	public static void main (String [] zzzz) {
		long before=System.currentTimeMillis();
		String [] cubeFormatted=new String [10000];
		for (int i=0;i<10000;i++) {
			cubeFormatted[i]=formatString((long)i*i*i);
		}
		
		for (int i=1;i<10000;i++) {
			int occurance=1;
			for (int i2=i+1;i2<10000;i2++) {
				if (cubeFormatted[i].equals(cubeFormatted[i2])) {
					occurance++;
				}
			}
			if (occurance==5) {
				System.out.println((long)i*i*i);
				break;
			}
		}
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}