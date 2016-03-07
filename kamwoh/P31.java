
package projecteuler;

import java.util.TreeMap;


public class P31 {

    public static void main(String[] args)
    {
        int[] val = new int[11];
        //int[] rm = {1,2,5,10,20,50,100,200};
        int[] rm = {1,2,5};
        val[0] = 1; //1 to 0
        int sum = 0;
        int n = 10;
        for(int i=n;i>=0;i--)
        {
            sum+=(in(n,i,rm));
            System.out.println(i+" out "+out(i,rm));
            System.out.println(i+" in "+in(n,i,rm));
        }
        
        System.out.println("sum "+sum);
    }
    
    public static int countIn(int limit, int n, int[] rm)
    {
        int count = 0;
        for(int i=0;i<rm.length;i++)
        {
            if(n+rm[i]<=limit)
                count++;
        }
        return count;
    }
    
    public static int countOut(int n, int[] rm)
    {
        int count = 0;
        for(int i=0;i<rm.length;i++)
        {
            if(n-rm[i]>=0)
                count++;
        }
        return count;
    }
    
    public static int out(int n, int[] rm)
    {
        return countOut(n,rm);
    }
    
    public static int in(int limit, int n, int[] rm)
    {
        return countIn(limit,n,rm);
    }
    
    
}
