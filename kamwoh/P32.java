

package projecteuler;

/**
 *
 * @author Woh
 */
public class P32 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int total = 0;
        int count = 1;
        int ans;
        int tempMemory=-1;
        do
        {
            for(int i=1;i<=999;i++)
            {
                ans = findAnswer(i,count);
                if(isAnswer(ans,i,count))
                {
                    if(tempMemory==count)
                        continue;
                    tempMemory=count;
                    System.out.println("a "+ans+" b "+i+" count "+count);
                    total+=count;
                }
            }
            count++;
            
        }while(checkLength(count)<=4);
        
        //System.out.println(isPandigital(39,186,7253));
        System.out.println(total);
    }
    
    
    
    public static int findAnswer(int dividend, int product)
    {
        int ans = product/dividend;
        if(dividend*ans!=product||checkLength(ans, dividend, product)!=9)
            return -1; //false
        
        return ans;
    }
    
    public static int checkLength(int ans)
    {
        String s1 = String.valueOf(ans);
        return s1.length();
    }
    
    public static int checkLength(int multiplicand, int multiplier, int product)
    {
        String s1 = String.valueOf(multiplicand);
        String s2 = String.valueOf(multiplier);
        String s3 = String.valueOf(product);
        int total = s1.length() + s2.length() + s3.length();
        return total;
    }
    /*
    public static int[] findPandigitalProduct(int n)
    {
        
    }
    */
    public static boolean isAnswer(int multiplicand, int multiplier, int product)
    {
        int length = checkLength(multiplicand, multiplier, product);
        if(length!=9||multiplicand==-1||multiplier==-1||product==-1)
            return false;
        else
            return isPandigital(multiplicand, multiplier, product)&&withoutZero(multiplicand, multiplier, product);
    }
    
    public static boolean withoutZero(int multiplicand, int multiplier, int product)
    {
        String s1 = String.valueOf(multiplicand);
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)=='0')
                return false;
        }
        String s2 = String.valueOf(multiplier);
        for(int i=0;i<s2.length();i++)
        {
            if(s2.charAt(i)=='0')
                return false;
        }
        String s3 = String.valueOf(product);
        for(int i=0;i<s3.length();i++)
        {
            if(s3.charAt(i)=='0')
                return false;
        }
        return true;
    }
    
    public static boolean isPandigital(int multiplicand, int multiplier, int product)
    {
        boolean[] check = new boolean[10];
        for(int i=0;i<check.length;i++)
        {
            check[i]=false;
        }
        int mP = multiplicand;
        int mQ = multiplier;
        int p = product;
        int ans;
        while(mP!=0)
        {
            ans=mP%10;
            mP/=10;
            if(check[ans])
                return false;
            check[ans]=true;
        }
        while(mQ!=0)
        {
            ans=mQ%10;
            mQ/=10;
            if(check[ans])
                return false;
            check[ans]=true;
        }
        while(p!=0)
        {
            ans=p%10;
            p/=10;
            if(check[ans])
                return false;
            check[ans]=true;
        }
        return true;
    }
    
    public static boolean isPandigital(int n)
    {
        int nn = n;
        int ans;
        boolean[] check = new boolean[10];
        for(int i=0;i<check.length;i++)
        {
            check[i]=false;
        }
        while(nn!=0)
        {
            ans=nn%10;
            nn/=10;
            if(check[ans])
                return false;
            check[ans]=true;
        }
        return true;
    }
    /*
    public static boolean isPandigital(int n)
    {
        int nn = n;
        int length = 0;
        while(nn!=0)
        {
            nn/=10;
            length++;
        }
        boolean[] check = new boolean[length];
        for(int i=0;i<check.length;i++)
        {
            check[i]=false;
        }
        int ans;
        nn = n;
        while(nn!=0)
        {
            ans = nn%10;
            nn/=10;
            if(check[ans])
                return false;
            check[ans]=true;
        }
        return true;
    }*/
}
