class Main {
	
	public static int solve () {
		int million=1000000;
		int [] ways=new int [100001];
		ways[0]=1;
		for (int i=1;i<ways.length;i++) for (int i2=i;i2<ways.length;i2++)
			ways[i2]=(ways[i2]+ways[i2-i])%million;
		
		int answer=-1;
	
		for (int i=0;i<ways.length;i++) {
			if (ways[i]==0) {
				answer=i;
				break;
			}
		}
		
		return answer;
	}
	
	public static void main (String [] abc) {
		long startTime=System.currentTimeMillis();
		System.out.println(solve());
		long endTime=System.currentTimeMillis();
		System.out.println("Took "+(endTime-startTime)+"ms.");
	}
}