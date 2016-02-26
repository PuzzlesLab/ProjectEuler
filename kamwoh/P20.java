package projecteuler;
import java.math.BigInteger;
/**
 *
 * @author Woh
 */
public class P20 {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        int total;
        BigInteger number = new BigInteger("1");
        for(int i=1;i<=100;i++)
        {
            number=number.multiply(BigInteger.valueOf(i));
        }
        total=total(number.toString());
        System.out.println(total);
    }
    
    public static int total(String s)
    {
        int total=0;
        for(int i=0;i<s.length();i++)
        {
            total+=Integer.parseInt(s.substring(i,i+1));
        }
        return total;
    }
}
