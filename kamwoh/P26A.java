

package projecteuler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
/**
 *
 * @author Woh
 */
public class P26A {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        P26.v3();
        
        long before = System.currentTimeMillis();
        int scale = 1000;
        int max = doubleCheck(scale);
        while(max==scale-6)
            max = doubleCheck(scale*=2);
        System.out.println("time: "+(System.currentTimeMillis()-before));
        
        v2();
    }
    
    public static void v2()
    {
        long before = System.currentTimeMillis();
        int max = 0;
        int c;
        String n;
        for(int i=2;i<1000;i++)
        {
            if(Library.isPrime(i))
            {
                n=P26B.divide(1000,"1",""+i);
                n=remove(n);
                c = check(n);
                if(c>max&&c<994)
                    max=c;
            //System.out.println("n "+n+" "+c);
            }
        }
        System.out.println(max);
        System.out.println("time: "+(System.currentTimeMillis()-before));
    }
    
    public static int doubleCheck(int scale)
    {
        BigDecimal bd = new BigDecimal("1");
        BigDecimal quotient;
        BigDecimal ans;
        String s;
        int count;
        int max = 0;
        for(int i=1000;i>=2;i--)
        {
            if(Library.isPrime(i))
            {
                quotient = new BigDecimal(String.valueOf(i));
                ans = bd.divide(quotient,scale,RoundingMode.CEILING);
                s = remove(ans.toString());
                count = check(s);
                if(max<count&&count<scale-6)
                    max = count;
                //if(count>=994)
                //System.out.println("ans "+s+" "+count);
            }
        }
        System.out.println(max+" "+(max-1));
        return max;
    }
    
    public static String remove(String s)
    {
        return s.substring(2);
    }
    
    public static int check(String s)
    {
        if(s.length()<6)
            return s.length();
        String check = s.substring(0,6);
        //System.out.println("c "+check);
        int c = s.length();
        int count = 6;
        for(int i=6;i<s.length()-6;i++)
        {
            count++;
            if(s.substring(i, i+6).equals(check))
                break;
        }
        return count;
    }
    

}
