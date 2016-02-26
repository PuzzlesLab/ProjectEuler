

package projecteuler;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
/**
 *
 * @author Woh
 */
public class P26 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        double total;
        double n1=1000000;
        double n2;
        /*
        for(int i=11;i<1000;i++)
        {
            n2=i;
            total=n1/n2;
            //System.out.printf("%.32f\n",total);
            System.out.printf(n1+" / "+n2+" = %.32f \n",total);
        }*/
        int highestcyclic=0;
        int c=0;
        for(int i=1000;i>1;i--)
        {
            if(Library.isPrime(i))
                if(cyclic(i))
                    c=i;
            if(c>highestcyclic)
                highestcyclic=c;
        }
        
        System.out.println(highestcyclic);
        /*
        for(int i=2;i<100;i++)
        {
            if(prime(i))
                System.out.println(i+" is " +prime(i));
        }*/
    }

    public static void v3()
    {
        long before = System.currentTimeMillis();
        int highestcyclic=0;
        int c=0;
        for(int i=1000;i>1;i--)
        {
            if(Library.isPrime(i))
                if(cyclic(i))
                    c=i;
            if(c>highestcyclic)
                highestcyclic=c;
        }
        
        System.out.println(highestcyclic);
        System.out.println("time: "+(System.currentTimeMillis()-before));
    }
    
    public static boolean prime(int x)
    {
        for(int i=2;i<=x/2;i++)
        {
            if(x%i==0)
                return false;
        }
        return true;
    }
    
    public static boolean cyclic(double x)
    {
        double n1 = 1;
        double total;
        int count = 0;
        int repeating = (int)x - 1;
        int remainder = ((int)n1*10)%(int)x;
        int first = remainder; 
        //System.out.println(first);
        while(true)
        {
            remainder*=10;
            remainder%=(int)x;
            count++;
            if(remainder==first)
                break;
        }
        return repeating==count;
    }
}
