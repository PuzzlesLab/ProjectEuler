
public class Euler14 {
	static int []h = new int [10000001];
	public static int findNum (long n){
		int i= 1;
		if (n<1000001 && h[(int)n] != 0) return h[(int)n];
		while (n != 1){
			if (n < 1000001 && h[(int)n]!= 0) return (h[(int)n] + i);
			if (n %2== 0) n/=2;
			else n = n *3 + 1;
			i++;
		}
		
		return i;
	}
	public static void main (String[] arg){
		for (int i = 0; i < 1000001; i++){
			h[i] = 0;
		}
		h[1] = 1;
		int max = 1, maxIndex = 1, c ;
		for (int i = 1; i < 1000001; i++){
			h[i] = findNum (i);
			if (h[i] > max) { max = h[i]; maxIndex = i;}
			//System.out.println (i);
		}
		
		System.out.println (maxIndex + " " + max);
	}
}
