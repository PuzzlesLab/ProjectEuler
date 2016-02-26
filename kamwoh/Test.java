

package projecteuler;

/**
 *
 * @author Woh
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println(f(9)*3);
        System.out.println(f(9)*2);
        System.out.println(f(9)*3-f(9)*2);
        System.out.println(1000000-f(9)*2);
        System.out.println(f(9)*2+f(8)*6+f(7)*6+f(6)*2+f(5)*5+f(4)+f(3)*2+f(2)+f(1)+f(0));
        System.out.println(f(7)*5);
        
    }

    public static long f(int n)
    {
        
        if(n==0||n==1)
            return 1;
        else
            return n*f(n-1);
    }
}
