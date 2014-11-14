/*
 * Dynamic Programming Approach
 * Knapsack
 */
public class euler {
	
	public static int [] coinType={1,2,5,10,20,50,100,200};
	
	public static void main (String [] abc) {
		int [] way=new int [201];
		way[0]=1;
		for (int i=0;i<coinType.length;i++) {
			for (int i2=coinType[i];i2<=200;i2++) {
				way[i2]=way[i2]+way[i2-coinType[i]];
			}
		}
		System.out.println(way[200]);
	}
}