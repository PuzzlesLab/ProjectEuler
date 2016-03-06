

package projecteuler;

import java.util.ArrayList;

/**
 *
 * @author Woh
 */
public class P21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int total=0;
        /*System.out.println(d(220));
        System.out.println(d(284));
        System.out.println(getAmicable(220));
        System.out.println(getAmicable(284));
        System.out.println(isAmicable(284));
        System.out.println(d(10000));
        System.out.println(isAmicable(10000));
        System.out.println(d(14211));*/
        for(int i=1;i<=10000;i++)
        {
            if(isAmicable(i))
                total+=i;
        }
        System.out.println("total:"+total);
    }
    
    public static int[] properDivisor(int n)
    {
        ArrayList<Integer> properDivisor=new ArrayList<>();
        for(int i=1;i<=n/2;i++)
        {
            if(n%i==0)
                properDivisor.add(i);
        }
        Integer[] p = new Integer[properDivisor.size()];
        for(int i=0;i<p.length;i++)
        {
            p[i]=properDivisor.get(i);
        }
        int[] d = toIntArray(p);
        return d;
    }
    
    public static int d(int n)
    {
        int[] p = properDivisor(n);
        int total=0;
        for(int i=0;i<p.length;i++)
        {
            total+=p[i];
        }
        return total;
    }
    
    public static int[] toIntArray(Integer[] e)
    {
        int[] p = new int[e.length];
        for(int i=0;i<e.length;i++)
        {
            p[i]=e[i];
        }
        return p;
    }
    
    public static int getAmicable(int n)
    {
        int a = d(n);
        return a;
    }

    public static boolean isAmicable(int n)
    {
        int n1=n;
        int n2=d(n);
        /*System.out.println("n1:"+n1);
        System.out.println("get n1:"+getAmicable(n));
        System.out.println("n2:"+n2);
        System.out.println("get n2:"+getAmicable(n2));
        System.out.println("sdf:"+(getAmicable(n2)==n1));*/
        return (getAmicable(n1)==n2&&getAmicable(n2)==n1&&n1!=n2);
    }
}
