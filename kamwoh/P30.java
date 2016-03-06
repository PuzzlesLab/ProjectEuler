

package projecteuler;

/**
 *
 * @author Woh
 */
public class P30 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        long total=0;
        
        
        System.out.println(Math.pow(9,5));
        System.out.println(Math.pow(9,5)*5);
        System.out.println(Math.pow(9,5)*6);
        for(int i=2;i<=355000;i++)
        {
            //System.out.println("1");
            if(check(i))
            {
                System.out.println(i);
                total+=i;
            }
        }
        System.out.println("total="+total);
        
    }   
    
    public static int[] brk(int x)
    {
        int count=0;
        int[] y=new int[5];
        if(x>=100000)
            y=new int[6];
        while(x!=0)
        {
            y[count++]=x%10;
            x/=10;
        }
        return y;
    }
    
    public static long sumPower(int[] x)
    {
        long total=0;
        for(int i=0;i<x.length;i++)
        {
            total+=Math.pow(x[i], 5);
        }
        return total;
    }
    
    public static boolean check(int x)
    {
        return x==sumPower(brk(x));
    }
}
