

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
        
        System.out.println("string");
        String s = reverse("string");
        printDigit(4567);
    }

    public static String reverse(String s)
    {
        return reverse(s,0);
    }
    
    public static String reverse(String s, int index)
    {
        if(index==s.length())
            return "";
        //System.out.println(s.length()-1-index + " " + index + " " + s.charAt(s.length()-1-index));
        return s.charAt(s.length()-1-index)+reverse(s,index+1);
    }
    
    public static int sum(int n)
    {
        if(n==1)
            return n;
        
        return n+sum(n-1);
    }
    
    public static long f(int n)
    {
        
        if(n==0||n==1)
            return 1;
        else
            return n*f(n-1);
    }
    
    public static void printDigit(int n)
    {
        if(n>10)
        {
            printDigit(n/10);
            System.out.print(n%10+" ");
        }
        else
        {
            System.out.print(n%10+" ");
        }
    }
    
    public static void printDigit(int n, int index)
    {
         
        String s = String.valueOf(n);
        if(index<s.length())
        {
            System.out.print(s.charAt(index)+" ");
            printDigit(n,index+1);
        }
         
    }
}
