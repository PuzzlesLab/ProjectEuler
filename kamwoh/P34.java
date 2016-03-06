

package projecteuler;

/**
 *
 * @author Woh
 */
public class P34 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //System.out.println(isAnswer(145));
        int count = 3;
        int limit = factorial(9); 
        while(count<limit)
        {
            if(isAnswer(count))
                System.out.println("count "+count);
            count++;
        }
    }
    
    
    public static boolean isAnswer(int n)
    {
        int nn=n;
        int total = 0;
        while(nn!=0)
        {
            //System.out.println("nn "+nn);
            //System.out.println("total "+total);
            total+=factorial(nn%10);
            nn/=10;
        }
        return total==n;
    }

    public static int factorial(int n)
    {
        if(n==0||n==1)
            return 1;
        else
            return n*factorial(n-1);
    }
    
}
