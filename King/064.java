package euler;

public class euler {
	
	/*
	 *       y   
	 *  ------------
	 *   sqrt(n)-x
	 *  
	 *        y        sqrt(n) + x
	 *  ------------ x ------------
	 *   sqrt(n) - x   sqrt(n) + x
	 *   
	 *   
	 *   y [sqrt(n) + x]
	 *  -----------------  ..... = a
	 *       n - x^2
	 *   
	 *   
	 *             y [sqrt(n)+x]
	 *   (int) a + --------------  - (int) a
	 *                 n - x^2
	 *          
	 *              
	 *                y [sqrt(n)+x] - [(int)a](n - x^2)
	 *   (int) a + ------------------------------------
	 *                          n - x^2              
	 *                
	 *                               1
	 *               -------------------------------------
	 *    (int) a  +              n - x^2
	 *               ------------------------------------
	 *                  y [sqrt(n)+x] - [(int)a](n - x^2)     
	 *                
	 *                               1
	 *               -------------------------------------
	 *    (int) a  +              n - x^2
	 *               --------------------------------------------
	 *                  y {[sqrt(n)+x] - (1/y)[(int)a](n - x^2)} 
	 *                                
	 *                                    1
	 *                  -------------------------------------
	 *    (int) a  +                [(n - x^2)/y]
	 *               --------------------------------------------
	 *                      sqrt(n)+  x-(1/y)[(int)a](n - x^2)            
	 *     
	 *   therefore...
	 *   y1 = [(n - x^2)/y0]
	 *   x1 = x0-(1/y)[(int)a](n - x^2)
	 */
	
	public static class FractionSet implements Comparable<FractionSet> {
		int n;
		int x;
		int y;
		int a;
		
		public FractionSet () {}
		
		public FractionSet (int a, int n, int x, int y) {
			this.n=n;
			this.x=x;
			this.y=y;
			this.a=a;
		}
						 
		public FractionSet expand () {
			FractionSet f=new FractionSet();
			f.a= (int)((this.y*(Math.sqrt(n)+this.x)/(this.n-this.x*this.x)));
			f.n=n;
			f.y=(n-(this.x*this.x))/this.y;
			f.x=-(this.x-f.a*(this.n-this.x*this.x)/this.y);
			return f;
		}
		
		@Override
		public int compareTo(FractionSet f) {
			if (this.n==f.n && this.y==f.y && this.x==f.x && this.a==f.a) {
				return 0;
			}
			return -1;
		}
		
		@Override
		public String toString() {
			return "       "+y+"       \n---------------\nsqrt("+this.n+")"+" - "+this.x;
		}
	}

	public static FractionSet [] expansions;
	public static int expansionCount;
	public static void expandHelper (FractionSet f) {
		boolean exists=false;
		for (int i=0;i<expansionCount;i++) {
			if (expansions[i].compareTo(f)==0) {
				exists=true;
			}
		}
		if (!exists) {
			expansions[expansionCount++]=f;
			expandHelper(f.expand());
		}
	}
	
	public static void expand (int n) {
		expansions=new FractionSet[300];
		expansionCount=0;
		expandHelper(new FractionSet((int)Math.sqrt(n),n,(int)Math.sqrt(n),1));
		expansionCount--; //Ignore the first expansion.
	}
	
	public static void debugExpand (int n) {
		expand(n);
		System.out.print("Sqrt("+n+")=["+expansions[0].a+"(");
		for (int i=1;i<expansionCount-1;i++) {
			System.out.print(expansions[1].a+",");
		}
		System.out.println(expansions[expansionCount-1].a+")], period="+expansionCount);
	}
	
	public static void main (String [] zzzz) {
		long before=System.currentTimeMillis();
		int oddCount=0;
		for (int n=2;n<=10000;n++) {
			double sqrt=Math.sqrt(n);
			if (sqrt!=(double)(int)sqrt) { //perform operation on non perfect squares.
				expand(n);
				//debugExpand(n);
				if (expansionCount%2==1) {
					oddCount++;
				}
			}
		}
		System.out.println(oddCount);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}