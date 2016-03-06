package projecteuler;

public class P12Highlydivisibletriangularnumber
{
    public static int nFactor(long n1)
    {
        int n2=0;
        int sqrt=(int)Math.sqrt(n1);
        for(int i=1;i<=sqrt;i++)
        {
            if(n1%i==0)
                n2+=2;
        }
        if(sqrt*sqrt==n1)
            n2--;
        return n2;
    }
    
    public static long triangular(int n1)
    {
        if(n1==1)
            return n1;
        long n2=n1+triangular(n1-1);
        return n2;
    }
    
    public static void main(String[] args)
    {
        long n1=0;
        int i=1;
        int divisor=0;
        //n1 = triangular(7);
        //divisor=nFactor(n1);
        //while(true)
        for(int j=1;;j++)
        {
            //n1 = triangular(i++);
            n1 += j;
            if(n1%2==1)
                continue;
            divisor=nFactor(n1);
            //if(divisor>100)
                //System.out.println("divisor "+divisor);
            //if(divisor>200)
                //System.out.println("n1 "+n1);
            if(divisor>500)
                break;
        }
        
        System.out.println("divisor "+divisor);
        System.out.println("n1 "+n1);
    }
}
    