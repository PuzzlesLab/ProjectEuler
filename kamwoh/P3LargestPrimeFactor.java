
package projecteuler;


public class P3LargestPrimeFactor 
{

    public static void main(String[] args) 
    {
       //long x = 360;
       long x = 600851475143L;
       int count = 0;
       for(int i=1;i<=x;i++)
       {
           if(Library.isPrime(i))
            if(x%i == 0)
            {
                System.out.println("x "+x);
                System.out.println("possible factors " + i);
                x = x/i;
                i--;
                System.out.println("after x "+x);
            }
           //count++;
           //System.out.println("count "+count);
        }
    }
}
