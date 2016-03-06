package projecteuler;
import java.util.*;

public class P14LongestCollatzSequence
{
    private static int count;
    public static int even(int n)
    {
        return n/2;
    }
    
    public static int odd(int n)
    {
        return 3*n+1;
    }
    
    public static long check(long n)
    {
        count++;
        //System.out.println("n:"+n);
        if(n==1)
        {
            return n;
        }
        if(n%2==0)
        {
            n/=2;
            return check(n);
        }
        else
        {
            n=3*n+1;
            return check(n);
        }
    }
    
    public static void main(String[] args)
    {
        int max=0;
        long maxi=0;
        for(long i=999999;i>1;i--)
        {
            count=1;
            check(i);
            if(max<count)
            {
                maxi=i;
                max=count;
            }
        }
        System.out.println("max i:"+maxi);
        System.out.println("maxcount:"+max);
    }
}