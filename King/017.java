public class euler {
	
	public static String [] numbersInWord=new String [1001];
	
	public static void main (String [] abc) {
		numbersInWord[1]="one";
		numbersInWord[2]="two";
		numbersInWord[3]="three";
		numbersInWord[4]="four";
		numbersInWord[5]="five";
		numbersInWord[6]="six";
		numbersInWord[7]="seven";
		numbersInWord[8]="eight";
		numbersInWord[9]="nine";
		numbersInWord[10]="ten";
		numbersInWord[11]="eleven";
		numbersInWord[12]="twelve";
		numbersInWord[13]="thirteen";
		numbersInWord[14]="fourteen";
		numbersInWord[15]="fifteen";
		numbersInWord[16]="sixteen";
		numbersInWord[17]="seventeen";
		numbersInWord[18]="eighteen";
		numbersInWord[19]="nineteen";
		numbersInWord[20]="twenty";
		numbersInWord[30]="thirty";
		numbersInWord[40]="forty";
		numbersInWord[50]="fifty";
		numbersInWord[60]="sixty";
		numbersInWord[70]="seventy";
		numbersInWord[80]="eighty";
		numbersInWord[90]="ninety";
		numbersInWord[1000]="onethousand";
		for (int i=21;i<100;i++) {
			if (i%10!=0) {
				numbersInWord[i]=numbersInWord[i/10*10]+numbersInWord[i%10];
			}
		}
		for (int i=100;i<1000;i++) {
			numbersInWord[i]=numbersInWord[i/100]+"hundred";
			if (i%100!=0) {
				numbersInWord[i]+="and"+numbersInWord[i%100];
			}
		}
		int alphabetCount=0;
		for (int i=1;i<1001;i++) {
			alphabetCount+=numbersInWord[i].length();
		}
		System.out.println(alphabetCount);
	}
}