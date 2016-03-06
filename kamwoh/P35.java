

package projecteuler;

import java.util.ArrayList;

/**
 *
 * @author Woh
 */
public class P35 {

    static int max;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int count = 1; //2 is a prime
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        System.out.println("i "+2);
        for(int i=3;i<1000000;i+=2)
        {
            if(!list.contains(i)&&isPrime(i))
                if(isCircularPrime(i))
                {
                    list.add(i);
                    //i = max;
                    count++;
                    System.out.println("i "+i);
                }
        }
        System.out.println(count);
        /*for(int i=0;i<c.length;i++)
        {
            System.out.println(c[i]);
        }*/
        
    }
    
    public static boolean isCircularPrime(int n)
    {
        int[] circular = getCircular(n);
        for(int i=0;i<circular.length;i++)
        {
            if(!isPrime(circular[i]))
                return false;
        }
        max = getMax(circular);
        return true;
    }
    
    public static int getMax(int[] n)
    {
        int max = n[0];
        for(int i=1;i<n.length;i++)
        {
            if(max<n[i])
                max = n[i];
        }
        return max;
    }
    
    public static int[] getCircular(int n)
    {
        int nn=n;
        int[] circular = new int[getLength(n)];
        for(int i=0;i<circular.length;i++)
        {
            circular[i]=nn;
            nn=rotate(nn);
            //System.out.println(circular[i]);
        }
        return circular;
    }
    
    public static int rotate(int n)
    {
        int nn=(int)n/10;
        int rotate;
        rotate=nn+(n%10)*(int)Math.pow(10,getLength(nn));
        return rotate;
    }
    
    public static int getLength(int n)
    {
        String s1 = String.valueOf(n);
        return s1.length();
    }
    
    public static boolean isPrime(int n)
    {
        int sqrt = (int)Math.sqrt(n);
        if(sqrt*sqrt==n)
            return false;
        
        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }

}
