

package projecteuler;

/**
 *
 * @author Woh
 */
public class P36 {
//double base palindrome
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long total = 0;
        for(int i=0;i<1000000;i++)
        {
            if(isAnswer(i))
                total+=i;
        }
        System.out.println(total);
    }
    
    public static boolean isAnswer(int n)
    {
        String s = Integer.toBinaryString(n);
        return isPalindrome(s)&&isPalindrome(n);
    }
    
    public static boolean isPalindrome(String s)
    {
        for(int i=0;i<s.length()/2;i++)
        {
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }

    public static boolean isPalindrome(int n)
    {
        String s = String.valueOf(n);
        for(int i=0;i<s.length()/2;i++)
        {
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
}
