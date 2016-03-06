

package projecteuler;

/**
 *
 * @author Woh
 */
public class P37 {

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int count = 0;
        int n = 3;
        int total = 0;
        while(count<11)
        {
            if(isTruncatablePrime(n)&&isTruncatablePrime(mirror(n)))
            {
                total+=n;
                System.out.println("n "+n);
                count++;
            }
            n+=2;
           //System.out.println("n "+n);
        }
        //System.out.println(total);
    }
    
    public static int mirror(int n)
    {
        String s = String.valueOf(n);
        int nn = 0;
        for(int i=s.length()-1;i>=0;i--)
        {
            //System.out.println(s.charAt(s.length()-1-i));
            nn += Integer.parseInt(String.valueOf(s.charAt(i)))*(int)Math.pow(10, i);
        }
        return nn;
    }
    
    public static boolean isTruncatablePrime(int n)
    {
        if(Library.getLength(n)<2)
            return false;
        int nn = n;
        int count = 2;
        //int formula;
        while(nn!=0)
        {
            if(!Library.isPrime(nn))
                return false;
            nn/=10;
        }
        nn = n%10;
        while(count<=Library.getLength(nn))
        {
            if(!Library.isPrime(nn))
                return false;
            nn=n%(int)Math.pow(10, count);
            count++;
        }
        return true;
    }

}
