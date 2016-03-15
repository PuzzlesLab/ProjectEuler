
package projecteuler;


public class P33 {

    public static void main(String[] args)
    {
        for(int i=10;i<100;i++)
        {
            for(int j=i;j<=i;j++)
            {
                if(answer(j,i,getLast(j)))
                    System.out.println("num "+j+" det "+i);
            }
        }
        int num = 49;
        int det = 98;
        int n1 = getLast(num);
    }
    
    public static int getLast(int num)
    {
        return num%10;
    }
    
    public static double nonTrivial(int n, int d, int n1)
    {
        return (double)getNum(n,n1)/(double)getDet(d,n1);
    }
    
    public static boolean answer(int numerator, int denominator, int n1)
    {
        if(numerator<10||numerator>=100||denominator<10||denominator>=100)
            return false;
        double n = (double)numerator/(double)denominator;
        if(n==nonTrivial(numerator,denominator,n1))
            return true;
        
        return false;
    }
    
    public static int getNum(int n, int n1)
    {
        return (n-n1)/10;
    }
    
    public static int getDet(int n, int n1)
    {
        return n-(n1*10);
    }
    
}
