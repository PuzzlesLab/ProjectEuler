import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class euler {

	/*
	 * Rules :
	 *  Numerals must be arranged in descending order of size.
		M, C, and X cannot be equaled or exceeded by smaller denominations.
		D, L, and V can each only appear once.
		Only one I, X, and C can be used as the leading numeral in part of a subtractive pair.
		I can only be placed before V and X.
		X can only be placed before L and C.
		C can only be placed before D and M.
		
		Possible representation :
		I - 1
		IV - 4
		V - 5
		IX - 9
		X - 10
		XL - 40
		L - 50
		XC - 90
		C - 100
		CD - 400
		D - 500
		CM - 900
		M - 1000
	 */
	
	public static class Representation {
		public String [] str;
		public int value;
		
		public Representation (int v, String s) {
			this.value=v;
			this.str=new String[10];
			StringBuilder sb=new StringBuilder("");
			for (int i=0;i<this.str.length;i++) {
				this.str[i]=sb.toString();
				sb.append(s);
			}
		}
	}
	
	public static Representation [] rep;
	public static void cacheNumToRoman () {
		rep=new Representation [13];
		rep[0]=new Representation(1,"I");
		rep[1]=new Representation(4,"IV");
		rep[2]=new Representation(5,"V");
		rep[3]=new Representation(9,"IX");
		rep[4]=new Representation(10,"X");
		rep[5]=new Representation(40,"XL");
		rep[6]=new Representation(50,"L");
		rep[7]=new Representation(90,"XC");
		rep[8]=new Representation(100,"C");
		rep[9]=new Representation(400,"CD");
		rep[10]=new Representation(500,"D");
		rep[11]=new Representation(900,"CM");
		rep[12]=new Representation(1000,"M");
	}

	public static String numToRoman (int num) {
		StringBuilder sb=new StringBuilder();
		for (int i=rep.length-1;i>=0;i--) {
			sb.append(rep[i].str[num/rep[i].value]);
			num=num%rep[i].value;
		}
		return sb.toString();
	}
	
	public static int [] alphabetToValue;
	public static void cacheRomanToNum () {
		alphabetToValue=new int ['Y'];
		alphabetToValue['I']=1;
		alphabetToValue['V']=5;
		alphabetToValue['X']=10;
		alphabetToValue['L']=50;
		alphabetToValue['C']=100;
		alphabetToValue['D']=500;
		alphabetToValue['M']=1000;
	}
	
	public static int romanToNum(String s) {
		int number=0;
		for (int i=0;i<s.length();i++) {
			if (i<s.length()-1 && alphabetToValue[s.charAt(i)]<alphabetToValue[s.charAt(i+1)]) {
				//Consider for IX, IV.... cases
				//Check by exploiting the property "Numerals must be arranged in descending order of size."
				number+=(alphabetToValue[s.charAt(i+1)]-alphabetToValue[s.charAt(i)]);
				i++;
			} else {
				number=number+alphabetToValue[s.charAt(i)];
			}
		}
		return number;
	}
	
	public static void main (String [] zzz) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("D:\\Documents\\King\\Desktop\\p089_roman.txt"));
		String [] data=new String[1000];
		for (int i=0;i<data.length;i++) {
			data[i]=br.readLine();
		}
		br.close();
		
		long before=System.currentTimeMillis();
		cacheNumToRoman();
		cacheRomanToNum();
		int oldLength=0;
		int newLength=0;
		for (int i=0;i<1000;i++) {
			oldLength=oldLength+data[i].length();
			newLength=newLength+numToRoman(romanToNum(data[i])).length();
		}
		System.out.println(oldLength-newLength);
		long after=System.currentTimeMillis();
		System.out.println("Time taken "+(after-before)+" ms");
	}
}