import java.util.Arrays;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class euler {
	
	private static int [] uniqueDigitsNumbers=new int [100000];
	private static int uniqueDigitsNumbersCount=0;
	private static int [] digitsCount=new int [100000];
	private static boolean [] isUniqueDigitsNumber = new boolean [100000];
	private static boolean [][] uniqueDigitsTable = new boolean [100000][10];
	
	private static void createUniqueDigitsNumbers(int currSum, boolean [] hasDigits) {
		if (currSum<=99999) {
			if (currSum!=0) {
				uniqueDigitsNumbers[uniqueDigitsNumbersCount++]=currSum;
				isUniqueDigitsNumber[currSum]=true;
				uniqueDigitsTable[currSum]=new boolean [10];
				int count=0;
				int temp=currSum;
				while (temp>0) {
					uniqueDigitsTable[currSum][temp%10]=true;
					temp/=10;
					count++;
				}
				digitsCount[currSum]=count;
			}
			for (int i=1;i<10;i++) {
				if (!hasDigits[i]) {
					hasDigits[i]=true;
					createUniqueDigitsNumbers(currSum*10+i,hasDigits);
					hasDigits[i]=false;
				}
			}
		}
	}
	
	private static boolean checkUnique (int [] nums, int endIndex) {
		for (int i=1;i<10;i++) {
			int trueCount=0;
			for (int i2=0;i2<endIndex && trueCount<=1;i2++) {
				if (uniqueDigitsTable[nums[i2]][i]) {
					trueCount++;
				}
			}
			if (trueCount>1) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkPandigital (int [] nums) {
		for (int i=1;i<10;i++) {
			int trueCount=0;
			for (int i2=0;i2<nums.length && trueCount<=1;i2++) {
				if (uniqueDigitsTable[nums[i2]][i]) {
					trueCount++;
				}
			}
			if (trueCount!=1) {
				return false;
			}
		}
		return true;
	}
	
	public static void main (String [] abc) {
		long startTime=System.currentTimeMillis();
		
		createUniqueDigitsNumbers(0,new boolean[10]);
		Arrays.sort(uniqueDigitsNumbers, 0, uniqueDigitsNumbersCount);

		int firstSingleDigitPandigitalPos=Arrays.binarySearch(uniqueDigitsNumbers, 0, uniqueDigitsNumbersCount, 1);
		int firstQuadrapleDigitsPandigitalPos=Arrays.binarySearch(uniqueDigitsNumbers, 0, uniqueDigitsNumbersCount, 1234);
		
		int firstDoubleDigitsPandigitalPos=Arrays.binarySearch(uniqueDigitsNumbers, 0, uniqueDigitsNumbersCount, 12);
		int firstTripleDigitsPandigitalPos=Arrays.binarySearch(uniqueDigitsNumbers, 0, uniqueDigitsNumbersCount, 123);
		
		int [] rangeMin={firstSingleDigitPandigitalPos,firstQuadrapleDigitsPandigitalPos,firstDoubleDigitsPandigitalPos,firstTripleDigitsPandigitalPos};
		int [] rangeMax={firstDoubleDigitsPandigitalPos,uniqueDigitsNumbersCount,firstTripleDigitsPandigitalPos,firstQuadrapleDigitsPandigitalPos};
		
		SortedSet<Integer> list=new TreeSet<>();
		int [] numbersToCheck = new int [3];
		
		for (int range=0;range<rangeMin.length;range+=2) {
			for (int i=rangeMin[range];i<rangeMax[range] && digitsCount[uniqueDigitsNumbers[i]]<=2;i++) {
				int num1=uniqueDigitsNumbers[i];
				numbersToCheck[0]=num1;
				for (int i2=rangeMin[range+1];i2<rangeMax[range+1];i2++) {
					int num2=uniqueDigitsNumbers[i2];
					numbersToCheck[1]=num2;
					if (checkUnique(numbersToCheck,2)) {
						int result=num1*num2;
						numbersToCheck[2]=result;
						if (isUniqueDigitsNumber[result]) {
							int totalDigitsCount=digitsCount[num1]+digitsCount[num2]+digitsCount[result];
							if (totalDigitsCount==9  && checkPandigital(numbersToCheck) && !list.contains(result)) {
								list.add(result);
							} else if (totalDigitsCount>9) {
								break;
							}
						}
					}
				}
			}
		}
		
		int sum=0;
		Iterator<Integer> it=list.iterator();
		while (it.hasNext()) {
			sum+=it.next();
		}
		
		long processTime=System.currentTimeMillis()-startTime;
		System.out.println(sum+"\nTook "+processTime+"ms.");
	}

}