

package projecteuler;

/**
 *
 * @author Woh
 */
public class P41 {

    //P32 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(long i=987654321;i>=0;i-=2)
        {
            //if(Library.isPrime(i))
                //System.out.println(i);
            if(isPandigitalPrime(i))
            {
                System.out.println(i);
                break;
            }
        }
    }
    
    public static boolean isPandigitalPrime(long n)
    {
        if(!Library.isPrime(n))
            return false;
        String t = String.valueOf(n);
        for(int i=0;i<t.length();i++)
        {
            if(t.charAt(i)=='0')
                return false;
        }
        boolean[] check = new boolean[10];
        for(int i=0;i<check.length;i++)
        {
            check[i]=false;
        }
        long nn = n;
        long ans;
        while(nn!=0)
        {
            ans = nn%10;
            nn/=10;
            if(check[(int)ans])
                return false;
            check[(int)ans]=true;
        }
        return true;
    }
    

}
