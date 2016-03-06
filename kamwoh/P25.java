

package projecteuler;

import java.math.BigInteger;

/**
 *
 * @author Woh
 */
public class P25 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long i=1;
        BigInteger n;
        long start=System.currentTimeMillis();
        //System.out.println(fib(12));
        //System.out.println(start);
        while(true)
        {
            n=fib(i);
            if(digit(n))
                break;
            i++;
        }
        long end=System.currentTimeMillis();
        //System.out.println(end);
        System.out.println((end-start) + "ms");
        System.out.println("term:"+i);
    }

    public static BigInteger fib(long index)
    {
        /*if(index==1||index==2)
        {
            return new BigInteger("1");
        }
        else
        {
            return fib(index-1).add(fib(index-2));
        }*/
        BigInteger f0 = new BigInteger("1");
        BigInteger f1 = new BigInteger("1");
        BigInteger f2 = new BigInteger("2");
        for(int i=3;i<index;i++)
        {
            f0 = f1;
            f1 = f2;
            f2 = f0.add(f1);
        }
        return f2;
    }
    
    public static boolean digit(BigInteger n)
    {
        int count=0;
        BigInteger zero = new BigInteger("0");
        while(!n.equals(new BigInteger("0")))
        {
            n=n.divide(new BigInteger("10"));
            count++;
        }
        return count==1000;
    }
}
