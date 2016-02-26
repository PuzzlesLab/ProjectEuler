

package projecteuler;
import java.util.ArrayList;
/**
 *
 * @author Woh
 */
public class P23 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] abundant = new int[28124];
        int total=0;
        int count=0;
        for(int i=1;i<=28123;i++)
        {
            if(!prime(i))
            {
                if(checkAbundant(i,d(i)))
                {   
                    abundant[count]=i;
                    count++;
                }
            }
        }
        
        int[] ans = sumOfAbundant(abundant);
        
        for(int i=0;i<ans.length;i++)
        {
            if(ans[i]==0)
                total+=i;
        }
        System.out.println(total);
        long end = System.currentTimeMillis();
        System.out.println((end-start)+"ms");
    }
    
    public static void display(int[] x)
    {
        for(int i=0;i<x.length;i++)
        {
            System.out.print(x[i]);
            if(i!=x.length-1)
                System.out.print(", ");
        }
        System.out.println("");
    }
    
    public static void displayln(int[] x)
    {
        for(int i=0;i<x.length;i++)
        {
            if(x[i]!=0)
            {
                System.out.println(x[i]);
            }
        }
        System.out.println("");
    }
    
    public static int[] sumOfAbundant(int[] x)
    {
        int temp;
        int[] y = new int[x.length]; 
        for(int i=0;i<x.length;i++)
        {
            if(x[i]==0)
                break;
            
            for(int j=i;j<x.length;j++)
            {
                if(x[j]==0)
                    break;
                
                temp=x[i]+x[j];
                if(temp<=28123&&temp>=0)
                    y[temp]=1;
            }
        }
        return y;
    }
    
    public static boolean checkAbundant(double x, ArrayList<Integer> divisor)
    {
        return x<total(divisor);
    }
    
    public static int total(ArrayList<Integer> x)
    {
        int t = 0;
        for(int x1:x)
            t+=x1;
        return t;
    }
    
    public static ArrayList<Integer> d(double y)
    {
        ArrayList<Integer> divisor = new ArrayList<>();
        int x = (int)y;
        for(int i=1;i<=x/2;i++)
        {
            if(x%i==0)
                divisor.add(i);
        }
        return divisor;
    }

    public static int[] toArray(ArrayList<Integer> x)
    {
        int[] y = new int[x.size()];
        for(int i=0;i<y.length;i++)
        {
            y[i]=x.get(i);
        }
        return y;
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
    
}
