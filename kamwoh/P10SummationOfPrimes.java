
package projecteuler;


public class P10SummationOfPrimes 
{
    public static boolean isPrime(long x)
    {
        int sq = (int)Math.sqrt(x);
        if(x==sq*sq)
            return false;
        else
        {
        for(long i=2;i*i<x;i++)
        {
            if(x%i==0)
            {
                return false;
            }
        }
        return true;
        }
    }

    public static void main(String[] args) 
    {
        long total=2,maxprime=0;
        long start = System.currentTimeMillis();
        for(long i=3;i<2000000;i+=2)
        {
            //if(i%2==1)
                if(Library.isPrime(i))
                    //if(maxprime<i)
                    {   //maxprime = i;
                        //System.out.println(i);  
                        total+=i;
                    }
        }
       /*if(isPrime(7))
            System.out.println("yes");*/
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
        //System.out.println(maxprime);
        System.out.println(total);
    }


    

}
