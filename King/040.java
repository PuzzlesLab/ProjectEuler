public class euler {
	
	public static void main (String [] args) {
		long before=System.currentTimeMillis();
		int currLength=0;
		int [] checkpoints={1,10,100,1000,10000,100000,1000000};
		int nextCheckpoint=0;
		int answer=1;
		for (int i=1;currLength<=1000000;i++) {
			currLength=currLength+((int)Math.log10(i)+1);
			if (currLength>=checkpoints[nextCheckpoint]) {
				int lastPosition=currLength-checkpoints[nextCheckpoint];
				int toDivide=i;
				for (int i2=0;i2<lastPosition;i2++) {
					toDivide/=10;
				}
				answer=answer*(toDivide%10);
				nextCheckpoint++;
			}
		}
		System.out.println(answer);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
} 