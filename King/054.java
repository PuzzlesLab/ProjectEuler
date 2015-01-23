package euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class euler {
	
	/* Score information
	 * 
	 * High Card - 0 to 12
	 * One Pair - 13 to 25
	 * Two Pairs - 26 to 38
	 * Three of a Kind - 39 to 51
	 * Straight - 52 to 61 // we set according to the maximum word value, so the case ranges from 4 to 12...
	 * Flush - 62 to 74 
	 * Full House - 75 - 219 // take care of both triples and doubles
	 * Four of a Kind - 219 - 231
	 * Straight Flush - 231 - 243
	 * Royal Flush - 243
	 */
	
	public static int [] WordValue=new int [128];
	
	public static void initializeWordValue () {
		WordValue['2']=0;
		WordValue['3']=1;
		WordValue['4']=2;
		WordValue['5']=3;
		WordValue['6']=4;
		WordValue['7']=5;
		WordValue['8']=6;
		WordValue['9']=7;
		WordValue['T']=8; //For 10
		WordValue['J']=9;
		WordValue['Q']=10;
		WordValue['K']=11;
		WordValue['A']=12;
	}
	
	public static class Card implements Comparable<Card>{
		char word;
		char suit;
		
		@Override
		public int compareTo(Card c) {
			return WordValue[this.word]-WordValue[c.word];
		}
		
	}
	
	public static void displayCards (Card[] c) {
		for (int i=0;i<5;i++) {
			System.out.print(c[i].word+""+c[i].suit+", ");
		}
	}
	
	public static boolean hasSameSuit (Card[] c) {
		boolean sameSuit=true;
		int suit=c[0].suit;
		for (int i=1;i<c.length;i++) {
			if (c[i].suit!=suit) {
				return false;
			}
		}
		return true;
	}
	
	public static int getPairCount (Card[] c) {
		int pairCount=0;
		boolean [] marked=new boolean [5];
		for (int i=0;i<4;i++) {
			if (!marked[i]) {
				int wordCount=1;
				char word=c[i].word;
				for (int i2=i+1;i2<5;i2++) {
					if (c[i2].word==word) {
						wordCount++;
						marked[i2]=true;
					}
				}
				if (wordCount==2) {
					pairCount++;
				}
			}
		}
		return pairCount;
	}
	
	public static char getHighestPairWord (Card[] c) {
		char highestPairWord='0';
		boolean [] marked=new boolean [5];
		for (int i=0;i<4;i++) {
			if (!marked[i]) {
				int wordCount=1;
				char word=c[i].word;
				for (int i2=i+1;i2<5;i2++) {
					if (c[i2].word==word) {
						wordCount++;
						marked[i2]=true;
					}
				}
				if (wordCount==2) {
					highestPairWord=word;
				}
			}
		}
		return highestPairWord;
	}
	
	public static char getHighestThreeOfAKindWord (Card[] c) {
		char highest3Word='0';
		boolean [] marked=new boolean [5];
		for (int i=0;i<3;i++) {
			if (!marked[i]) {
				int wordCount=1;
				char word=c[i].word;
				for (int i2=i+1;i2<5;i2++) {
					if (c[i2].word==word) {
						wordCount++;
						marked[i2]=true;
					}
				}
				if (wordCount==3) {
					highest3Word=word;
				}
			}
		}
		return highest3Word;
	}
	
	public static char getHighestConsecutiveWord (Card[] c) {
		for (int i=1;i<5;i++) {
			if (WordValue[c[i].word]-WordValue[c[i-1].word]!=1) {
				return '0';
			}
		}
		return c[4].word;
	}
	
	public static char getHighestFourOfAKindWord (Card[] c) {
		char highest4Word='0';
		for (int i=0;i<4;i++) {
			int wordCount=0;
			char word=c[i].word;
			for (int i2=i+1;i2<5;i2++) {
				if (c[i2].word==word) {
					wordCount++;
				}
			}
			if (wordCount==4) {
				highest4Word++;
			}
		}
		return highest4Word;
	}
	
	public static int getScore (Card[] c) {
		char highestConsecutiveWord=getHighestConsecutiveWord(c);
		boolean inSameSuit=hasSameSuit(c);
		if (highestConsecutiveWord!='0' && inSameSuit) {
			System.out.println("Straight flush");
			return 231+WordValue[highestConsecutiveWord]; //Straight flush and royal flush
		} else if (getHighestFourOfAKindWord(c)!='0') {
			return 219+WordValue[getHighestFourOfAKindWord(c)]; //Four of a kind
		} else if (getHighestThreeOfAKindWord(c)!='0' && getPairCount(c)==1) {
			return 75+WordValue[getHighestThreeOfAKindWord(c)]*12+WordValue[getHighestPairWord(c)]; //Full house
		} else if (inSameSuit) {
			return 62+WordValue[c[4].word]; //flush
		} else if (highestConsecutiveWord!='0') {
			return 52+(WordValue[c[4].word]-3); //straight
		} else if (getHighestThreeOfAKindWord(c)!='0') {
			return 39+WordValue[getHighestThreeOfAKindWord(c)]; //three of a kind
		} else if (getPairCount(c)==2) {
			return 26+WordValue[getHighestPairWord(c)]; //2 pairs
		} else if (getPairCount(c)==1) {
			return 13+WordValue[getHighestPairWord(c)]; //1 pair
		} else {
			return WordValue[c[4].word];
		}
	}
	
	public static void main (String [] zzzz) throws Exception {
		long before=System.currentTimeMillis();
		initializeWordValue();
		BufferedReader br=new BufferedReader(new FileReader("p054_poker.txt"));
		Card [] p1Cards;
		Card [] p2Cards;
		String input;
		int p1WinCount=0;
		while ((input=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(input);
			p1Cards=new Card[5];
			p2Cards=new Card[5];
			for (int i2=0;i2<5;i2++) {
				String s=st.nextToken();
				p1Cards[i2]=new Card();
				p1Cards[i2].word=s.charAt(0);
				p1Cards[i2].suit=s.charAt(s.length()-1);
			}
			for (int i2=0;i2<5;i2++) {
				String s=st.nextToken();
				p2Cards[i2]=new Card();
				p2Cards[i2].word=s.charAt(0);
				p2Cards[i2].suit=s.charAt(s.length()-1);
			}
			Arrays.sort(p1Cards);
			Arrays.sort(p2Cards);
			int p1Score=getScore(p1Cards);
			int p2Score=getScore(p2Cards);
			if (p1Score>p2Score) {
				p1WinCount++;
			} else if (p1Score==p2Score && WordValue[p1Cards[4].word]>WordValue[p2Cards[4].word]) {
				p1WinCount++;
			}
		}
		System.out.println(p1WinCount);
		System.out.println("Took "+(System.currentTimeMillis()-before)+"ms.");
	}
}