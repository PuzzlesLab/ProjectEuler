public class euler {
	
	public static int [] wordCount=new int [1001];
	
	public static void main (String [] abc) {
		wordCount[1]=3;//one
		wordCount[2]=3;//two
		wordCount[3]=5;//three
		wordCount[4]=4;//four
		wordCount[5]=4;//five
		wordCount[6]=3;//six
		wordCount[7]=5;//seven
		wordCount[8]=5;//eight
		wordCount[9]=4;//nine
		wordCount[10]=3;//ten
		wordCount[11]=6;//eleven
		wordCount[12]=6;//twelve
		wordCount[13]=8;//thirteen
		wordCount[14]=8;//fourteen
		wordCount[15]=7;//fifteen
		wordCount[16]=7;//sixteen
		wordCount[17]=9;//seventeen
		wordCount[18]=8;//eighteen
		wordCount[19]=8;//nineteen
		wordCount[20]=6;//twenty
		wordCount[30]=6;//thirty
		wordCount[40]=5;//forty
		wordCount[50]=5;//fifty
		wordCount[60]=5;//sixty
		wordCount[70]=7;//seventy
		wordCount[80]=6;//eighty
		wordCount[90]=6;//ninety
		wordCount[1000]=11;//onethousand
		
		for (int i=21;i<100;i++) {
			//21 - 99
			if (i%10!=0) {
				wordCount[i]=wordCount[i/10*10]+wordCount[i%10];
			}
		}
		
		for (int i=100;i<1000;i++) {
			//100 - 999
			if (i%100!=0) {
				wordCount[i]=wordCount[i/100*100];
				wordCount[i]+=3+wordCount[i%100];
			} else {
				wordCount[i]=wordCount[i/100]+7;
			}
		}
		
		int sum=0;
		for (int i=1;i<1001;i++) {
			sum+=wordCount[i];
		}
		
		System.out.println(sum);
	}
}