

package projecteuler;

/**
 *
 * @author Woh
 */
public class P27 {

    static int maxI;
    static int maxJ;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int max = 0;
        int count=0;
        int c = 0;
        long n;
        
        for(int i=-999;i<1000;i++)
        {
            for(int j=-999;j<1000;j++)
            {
                count = 0;
                while(true)
                {
                    n = quadratic3(count,i,j);
                    if(isPrime(n))
                        count++;
                    else
                        break;
                    //count++;
                }
                if(max<count)
                {
                    maxI = i;
                    maxJ = j;
                    max=count;
                }
            }
        }
        //max = countPrime(max,0,40);
        
        System.out.println("a="+maxI+" b="+maxJ+" maxprime="+max);
        //System.out.println(999*61);
        System.out.println("ans="+(maxI*maxJ));
    }
    
    public static int countPrime(int max, int i, int j)
    {
        int mMax = max;
        int a = i;
        int b = j;
        long ans;
        int count=0;
        while(true)
        {
            System.out.println("s");
            ans = quadratic3(count,i,j);
            if(isPrime(ans))
                count++;
            else
                break;
        }
        
        if(mMax<count)
        {
            mMax = count;
            maxI = a;
            maxJ = b;
        }
        
        if(a==999&&b==999)
            return mMax;
        else
        {
            if(b==999)
                b=-1000;
            a++;
            b++;
            return countPrime(mMax,a,b);
        }
    }

    public static boolean isPrime(long n)
    {
        long nAbs = Math.abs(n);
        int sqrt = (int)Math.sqrt(nAbs);
        if(sqrt*sqrt==nAbs)
            return false;
        else
        {
            for(int i=2;i<=nAbs/2;i++)
            {
                 if(nAbs%i==0)
                     return false;
            }
            return true;
        }
    }
    
    public static long quadratic(int n)
    {
        return n*n+n+41;
    }
    
    public static long quadratic2(int n)
    {
        return n*n-79*n+1601;
    }
    
    public static long quadratic3(int n, int a, int b)
    {
        return n*n+a*n+b;
    }
}
