
package projecteuler;
import java.util.*;
import java.io.*;

public class P17 {
    
    
    static String[] belowten = {"one","two","three","four","five","six","seven","eight","nine"};
    static String[] specialafterten = {"ten","eleven","twelwe","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    static String[] ten = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    static String hundred = "hundred";
    static String thousand = "thousand";
    
    
    public static void main(String[] args)
    {
        
        int totalletter=0;
        int x=25;
        int tempx=x;
        int count=0;
        int temp;
        int[] y = {1,2,3,4,5,6,7,8,9};
        
        for(int j=1;j<=1000;j++)
        {
            x=j;
            if(x<100)
                totalletter+=totalletterbelowhundred(x);
            else if(x<1000)
                totalletter+=totalletterbelowthousand(x);
            
            if(x>=1000&&x<=9999)
            {
                for(int i=1;i<=9;i++)
                {
                    if(x/1000==i)
                    {
                        totalletter+=belowten[i-1].length();
                        totalletter+=thousand.length();
                        //System.out.print(belowten[i-1]+" "+thousand+" ");
                        if(x%1000==0)
                        {
                            //System.out.println("");
                            break; 
                        }
                        else
                        {
                            totalletter+=totalletterbelowthousand(x%1000);
                            break;
                        }
                    }
                }

            }
            //System.out.println("");
        //System.out.println(totalletter);
        }
        System.out.println(totalletter);
    }
    
    public static int totalletterbelowthousand(int x)
    {
        int totalletter=0;
        
        for(int i=1;i<=9;i++)
            {
                if(x/100==i)
                {
                    totalletter+=belowten[i-1].length();
                    totalletter+=hundred.length();
                    //System.out.print(belowten[i-1]+" "+hundred+" ");
                    if(x%100==0)
                    {
                        //System.out.println("");
                        break;
                    }
                    else
                    {
                        //System.out.print("and ");
                        totalletter+=3;
                        totalletter+=totalletterbelowhundred(x%100);
                        break;
                    }
                }
            }
        //System.out.println("In below thousand "+totalletter);
        return totalletter;
    }
    
    public static int totalletterbelowhundred(int x)
    {
        int totalletter=0;
        int temp;
        if(x<=19)
        {
            if(x<=9)
            {
                for(int i=0;i<10;i++)
                {
                    if(x==(i+1))
                    {
                        totalletter+=belowten[i].length();
                        //System.out.println(belowten[i]);
                        break;
                    }
                }
            }
            else
                for(int i=10;i<20;i++)
                {
                    if(x==i)
                    {
                        totalletter+=specialafterten[i-10].length();
                        //System.out.println(specialafterten[i-10]);
                        break;
                    }
                }
        }
        
        else if(x>=20&&x<=99)
        {
            temp=x/10;
            for(int i=2;i<=9;i++)   
            {
                if(x/10==i)    
                {
                    totalletter+=ten[i-2].length();
                    //System.out.print(ten[i-2]+" ");
                    //if(x%10==0)
                        //System.out.println("");
                    break;
                }
            }
            if(x%10!=0)
                for(int i=1;i<=9;i++)
                {
                    if(x%10==i)
                    {
                        totalletter+=belowten[i-1].length();
                        //System.out.println(belowten[i-1]);
                        break;
                    }
                }
        }
        //System.out.println("In below hundred "+totalletter);
        return totalletter;
        }
}

