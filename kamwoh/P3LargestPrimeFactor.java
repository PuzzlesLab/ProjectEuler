
package projecteuler;


public class P3LargestPrimeFactor 
{

    public static void main(String[] args) 
    {
       long x = 600851475143L;
       for(int i=1;i<=x;i++)
       {
            if(x%i == 0)
            {
                System.out.println("possible factors " + i);
                x = x/i;
            }
        }
    }
}
