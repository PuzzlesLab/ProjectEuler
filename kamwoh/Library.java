
package projecteuler;


public class Library {
    
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
    
    public static int getLength(int n)
    {
        String s1 = String.valueOf(n);
        return s1.length();
    }
    
    public static boolean isPrime(int n)
    {
        if(n==2)
            return true;
        
        if(n<=1||n%2==0)
            return false;
        
        int sqrt = (int)Math.sqrt(n);
        
        if(sqrt*sqrt==n)
            return false;
        
        for(int i=3;i<=sqrt;i++)
        {
            //System.out.println("i "+i+" i*i "+(i*i));
            if(n%i==0)
                return false;
        }
        return true;
    }
    
    public static boolean isPrime(long n)
    {
        if(n==2)
            return true;
        
        if(n<=1||n%2==0)
            return false;
        
        int sqrt = (int)Math.sqrt(n);
        
        if(sqrt*sqrt==n)
            return false;
        
        for(int i=3;i<=sqrt;i++)
        {
            //System.out.println("i "+i+" i*i "+(i*i));
            if(n%i==0)
                return false;
        }
        return true;
    }
    
    
}
