package euler;

import java.io.BufferedReader;
import java.io.FileReader;

public class euler {
	
	public static char [][] password=new char [26*26*26][3];
	
	public static void createPassword () {
		int count=0;
		for (int i='a';i<='z';i++) {
			for (int i2='a';i2<='z';i2++) {
				for (int i3='a';i3<='z';i3++) {
					password[count][0]=(char)i;
					password[count][1]=(char)i2;
					password[count][2]=(char)i3;
					count++;
				}
			}
		}
	}
	
	public static char[] decrypt (char [] encrypted, char [] password) {
		char [] result=new char [encrypted.length];
		for (int i=0;i<result.length;i++) {
			result[i]=(char)(encrypted[i]^(password[i%3]));
		}
		return result;
	}
	
	public static boolean containsUnprintableChar (char [] c) {
		for (int i=0;i<c.length;i++) {
			if (c[i]<32 || c[i]>126) {
				return true;
			}
		}
		return false;
	}
	
	public static void main (String [] zzzz) throws Exception {
		long phase1Start=System.currentTimeMillis();
		BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\King\\Desktop\\p059_cipher.txt"));
		String [] encryptedStr=br.readLine().split(",");
		char [] encryptedChar=new char[encryptedStr.length];
		for (int i=0;i<encryptedStr.length;i++) {
			encryptedChar[i]=(char)Integer.parseInt(encryptedStr[i]);
		}
		createPassword();
		for (int i=0;i<password.length;i++) {
			char [] decrypted=decrypt(encryptedChar,password[i]);
			if (!containsUnprintableChar(decrypted)) {
				String s="";
				for (int i2=0;i2<decrypted.length;i2++) {
					s=s+decrypted[i2];
				}
				System.out.println(password[i][0]+""+password[i][1]+""+password[i][2]+" - "+s);
			}
		}
		long phase2Start=System.currentTimeMillis();
		//After brute force, we found "god" is the password;
		char [] result=decrypt(encryptedChar,new char[]{'g','o','d'});
		int sum=0;
		for (int i=0;i<result.length;i++) {
			sum=sum+result[i];
		}
		long end=System.currentTimeMillis();
		System.out.println("--------------------------\nAnswer : "+sum);
		System.out.println("Brute force took "+(phase2Start-phase1Start)+"ms.");
		System.out.println("Sum took "+(end-phase2Start)+"ms.");
	}
}