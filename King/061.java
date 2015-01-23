package euler;

import java.util.LinkedList;

public class euler {
	
	public static LinkedList<Integer> [] PNumbers=new LinkedList [6];
	public static int [][] PatternSqn=new int [720][6];// 5!=120
	public static int PatternCount=0;
	
	/*
	P(3,n) - +2, +3, +4, +5.... increment per iteration increases by (n-2)
	P(4,n) - +3, +5, +7, +9
	P(5,n) - +4, +7, +10, +13
	P(6,n) - +5, +9, +13, +17
	*/
	
	public static void generatePermutation() {
		int [] set=new int [6];
		for (int i=0;i<6;i++) {
			set[0]=i;
			generatePermutationHelper(set,1);
		}
	}
	
	public static void generatePermutationHelper(int [] set, int n) {
		if (n==6) {
			for (int i=0;i<6;i++) {
				PatternSqn[PatternCount][i]=set[i];
			}
			PatternCount++;
		} else {
			for (int i=0;i<6;i++) {
				boolean exists=false;
				for (int i2=0;i2<n;i2++) {
					if (set[i2]==i) {
						exists=true;
					}
				}
				if (!exists) {
					set[n]=i;
					generatePermutationHelper(set,n+1);
				}
			}
		}
	}
	
	public static void check(int [] pattern) {
		int [] num=new int [6];
		for (int i=0;i<PNumbers[pattern[0]].size();i++) {
			num[0]=PNumbers[pattern[0]].get(i);
			checkHelper(pattern,1,num);
		}
	}
	
	public static void checkHelper(int [] pattern, int n, int [] num) {
		if (n==6) {
			if (num[5]%100==num[0]/100) {
				System.out.println(num[0]+" "+num[1]+" "+num[2]+" "+num[3]+" "+num[4]+" "+num[5]+" | Sum : "+(num[0]+num[1]+num[2]+num[3]+num[4]+num[5]));
			}
		} else {
			for (int i=0;i<PNumbers[pattern[n]].size();i++) {
				num[n]=PNumbers[pattern[n]].get(i);
				if (num[n-1]%100==num[n]/100) {
					checkHelper(pattern,n+1,num);
				}
			}
		}
	}
	
	public static void main (String [] zzzz) {
		long before=System.currentTimeMillis();
		for (int i=0;i<6;i++) {
			int increment=1;
			int currPNumber=1;
			PNumbers[i]=new LinkedList<>();
			while (currPNumber<10000) {
				if (currPNumber>1000) {
					PNumbers[i].add(currPNumber);
				}
				increment=increment+(i+3-2);
				currPNumber+=increment;
			}
		}
		//Done generating list of numbers.

		//Filter : Last 2 digits should be more than or equal to 10.
		for (int i=0;i<5;i++) {
			for (int i2=0;i2<PNumbers[i].size();i2++) {
				Integer num=PNumbers[i].get(i2);
				if (num%100<10) {
					PNumbers[i].remove(num);
					i2--;
				}
			}
		}
		
		//Filter : Remove those numbers that has first 2 digits that are doesn't occur in last 2 digits in any number.
		int [] numberOccurance=new int [100];
		for (int i=0;i<5;i++) {
			for (int i2=0;i2<PNumbers[i].size();i2++) {
				numberOccurance[PNumbers[i].get(i2)%100]++;
			}
		}

		for (int i=0;i<5;i++) {
			for (int i2=0;i2<PNumbers[i].size();i2++) {
				Integer num=PNumbers[i].get(i2);
				if (numberOccurance[num/100]==0) {
					PNumbers[i].remove(num);
					i2--;
				}
			}
		}
		
		//remove those numbers that has last 2 digits that don't exist in first 2 digits in other set.
		for (int i=0;i<5;i++) {
			for (int i2=0;i2<PNumbers[i].size();i2++) {
				Integer num=PNumbers[i].get(i2);
				if (numberOccurance[num%100]==1) {
					boolean exists=false;
					for (int i3=0;i3<PNumbers[i].size();i3++) {
						if (PNumbers[i].get(i3)/100==num%100) {
							exists=true;
							break;
						}
					}
					if (exists) {
						PNumbers[i].remove(num);
						i2--;
					}
				}
			}
		}
		
		generatePermutation();
		for (int i=0;i<PatternSqn.length;i++) {
			check(PatternSqn[i]);
		}
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
		
	}
}