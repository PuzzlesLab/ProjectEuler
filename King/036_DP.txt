public class euler {

	public static int [][] palindromes=new int [8][1001];
	public static int [] palindromesCount=new int [8];
	
	public static void generatePalindromes () {
		for (int i=1;i<10;i++) {
			palindromes[0][palindromesCount[0]++]=i;
		}
		for (int i=11;i<100;i+=11) {
			palindromes[1][palindromesCount[1]++]=i;
		}
		for (int digits=3;digits<7;digits++) {
			int powDigits=(int)Math.pow(10,digits-1);
			for (int i=0;i<palindromesCount[digits-2-1];i++) {
				for (int i2=1;i2<10;i2++) {
					palindromes[digits-1][palindromesCount[digits-1]++]=i2*powDigits+((palindromes[digits-2-1][i]*10)+i2);
				}
			}
			for (int i=1;i<10;i++) {
				palindromes[digits-1][palindromesCount[digits-1]++]=i*powDigits+i;
			}
		}
	}
	
	public static int [] powTwo=new int [21];
	
	public static void cacheBase2Check () {
		powTwo[0]=1;
		for (int i=1;i<powTwo.length;i++) {
			powTwo[i]=powTwo[i-1]*2;
		}
	}
	
	public static boolean base2Check(int num) {
		//1 million = 11110100001001000000
		int startPow=(int)(Math.log(num)/Math.log(2));
		boolean [] flag=new boolean [startPow+1];
		while (num!=0) {
			if (num>=powTwo[startPow]) {
				num=num-powTwo[startPow];
				flag[startPow]=true;
			}
			startPow--;
		}
		for (int i=0;i<flag.length/2;i++) {
			if (flag[i]!=flag[flag.length-1-i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main (String [] zzzz) {
		long before=System.currentTimeMillis();
		generatePalindromes();
		cacheBase2Check();
		int sum=0;
		for (int digits=0;digits<8;digits++) {
			for (int i=0;i<palindromesCount[digits];i++) {
				if (base2Check(palindromes[digits][i])) {
					sum+=palindromes[digits][i];
				}
			}
		}
		System.out.println(sum);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}