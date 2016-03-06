

package projecteuler;
import java.math.BigInteger;
import java.util.ArrayList;
/**
 *
 * @author Woh
 */
public class P29 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Double> ans = new ArrayList<>();
        BigInteger temp;
        double a;
        for(int i=2;i<=100;i++)
        {
            //temp = new BigInteger(String.valueOf(i));
            
            for(int j=2;j<=100;j++)
            {
                a=Math.pow(i, j);
                if(!ans.contains(a))
                    ans.add(a);
            }
        }
        /*
        int count=0;
        for(int i=0;i<ans.size();i++)
        {
            if(ans.get(i)==1)
                count++;
        }*/
        System.out.println(ans.size());
    }

}
