import java.math.BigInteger;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.IOException;

public class problem_22
{
	public static void main(String[]args)
	{
		long before=System.currentTimeMillis();
		Scanner fin=null;
		String content="";
		try
		{
			fin=new Scanner(new FileInputStream("p022_names.txt"));
			while(fin.hasNextLine())
			{
				content+=fin.nextLine();
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if(fin!=null)
				fin.close();
		}
		String[]tempString=content.split("\",\"");
		String[]name=new String[tempString.length];

		for(int i=0;i<tempString.length;i++)
		{
			name[i]="";
			for(int j=0;j<tempString[i].length();j++)
			{				
				if(tempString[i].charAt(j)>=65&&tempString[i].charAt(j)<=90)
				{					
					name[i]+=tempString[i].charAt(j);
				}			
			}
		}

		
		sort(name);
		/*for(int i=0;i<name.length;i++)
		{
			System.out.println(name[i]);
		}*/

		BigInteger ans=new BigInteger("0");
		long sumOfWord=0;
		long totalScore=0;

		for(int i=0;i<name.length;i++)
		{
			//System.out.println(name[i]);
			for(int j=0;j<name[i].length();j++)
			{
				if(name[i].charAt(j)>=65&&name[i].charAt(j)<=90)
				{
					sumOfWord+=(int)name[i].charAt(j)-64;
				}				
			}			
			//System.out.println(i+1);
			totalScore=(sumOfWord*(i+1));
			//System.out.println(totalScore);			
			BigInteger a=new BigInteger(Long.toString(totalScore));
			ans=ans.add(a);
			sumOfWord=0;
			totalScore=0;
		}

		System.out.println(ans);
		long after=System.currentTimeMillis();
		System.out.println("Time Taken = "+(after-before)+"ms");
	}

	public static void sort(String[]content)
	{
		for(int i=0;i<content.length;i++)
		{
			for(int j=1;j<content.length;j++)
			{
				if(content[j].compareTo(content[j-1])<0)
				{
					String temp=content[j];
					content[j]=content[j-1];
					content[j-1]=temp;
				}
			}
		}
	}
}