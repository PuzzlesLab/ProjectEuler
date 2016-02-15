import java.util.SortedSet;
import java.util.TreeSet;

public class euler {
	
	public static void main (String[] zzz) {
		long start=System.currentTimeMillis();
		SortedSet<Double> valuesSet=new TreeSet<>();
		for (int a=2;a<=100;a++) {
			for (int b=2;b<=100;b++) {
				double value=Math.pow(a, b);
				if (!valuesSet.contains(value)) {
					valuesSet.add(value);
				}
			}
		}
		System.out.println(valuesSet.size());
		long end=System.currentTimeMillis();
		System.out.println(end-start);
	}
	
}