
package projecteuler;

import java.util.ArrayList;


public class P4LargestPalindrome
{
	public static boolean isPalindrome(int number)
	{
	int temp=number;
        int temp2;
	int count=0;
	while(temp!=0)
	{
	temp2=temp%10;
        temp/=10;
	count++;
	}
        
	int[] digit=new int[count];
	temp = number;

	for(int i=0;i<count;i++)
	{
	if(temp!=0)
	{
		digit[i]=temp%10;
		temp/=10;
	}
	}

	int countdigit=0;	
	for(int j=0;j<count/2;j++)
	{	
	if(digit[j]==digit[count-1-j])
		countdigit++;
	}
        return (countdigit==count/2);
        }
        
	public static void main(String[] argv)
	{
            long start = System.currentTimeMillis();
		int checkpalindrome;
                int max=0;
		int x=10,y=10;
		for(int i=999;i>100;i--)
		{
			x=i;
			for(int j=999;j>100;j--)
			{	
                            
                            
				y=j;
				checkpalindrome=i*j;
				if(Library.isPalindrome(checkpalindrome)==true)
				{
                                    if(checkpalindrome>max)
                                        max = checkpalindrome;
				}

			}
		}
                System.out.println("Largest palindrome "+max);
                long end = System.currentTimeMillis();
                long timetaken = end - start;
                System.out.println("Time taken " +timetaken+ "ms");
	}
}