import java.io.*;
public class problem_4
{
	public static boolean isPalindrome(String a)
	{
		if(a.length()<=1)
			return true;
		else if(a.charAt(0)!=a.charAt(a.length()-1))
			return false;
		else
			return isPalindrome(a.substring(1,a.length()-1));
	}

	public static void main(String[]args)
	{
		long timestampBefore=System.currentTimeMillis();
		String s;
		int edit=0;
		int max=0;
		for(int i=999;i>=1;i--)
		{
			for(int j=999;j>=1;j--)
			{
				edit=i*j;
				s=Integer.toString(edit);
				if(isPalindrome(s))
				{
					if(edit>max)
					{
						max=edit;
					}

				}
			}
		}

		System.out.println(max);
		long timestampAfter=System.currentTimeMillis();
		long timeTaken=timestampAfter-timestampBefore;
		System.out.println("Took " + timeTaken + "ms to run");
	}
}