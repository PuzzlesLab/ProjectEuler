
package projecteuler;


public class P710001stPrime 
{

    public static boolean isPrime(int x)
    {
        int sqrt = (int)Math.sqrt(x);
        if(sqrt*sqrt==x)
            return false;
        else
        {
            for(int i=2;i*i<x;i++)
            {
                if(x%i==0)
                    return false;
            }
            return true;
        }
    }
    public static void main(String[] args) 
    {
        long start = System.currentTimeMillis();
        int number=3;
        int count=1; //2 already counted
        //boolean check=false;
        while(count<10001)
        {
            
            /*check=true;
            for(int i=2;i<number;i++)
            {
                if (number%i==0)
                {
                    check=false;
                    break;
                }
            }
            
            if(check)
            {
                count++;
                //System.out.println(number + " count " + count);
            } 
            number++;*/
            /*if(isPrime(number))
                count++;
            number++;*/
        //if(number%2==1)   
            if(isPrime(number))
            {
                count++;
                //System.out.println(number);
                //System.out.println(count);
                
            }
             
            if(count==10001)
                    break;
            number+=2;
            
            //System.out.println(number);
        }
        System.out.println(number + " " + count);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("Time taken " + time + "ms");
        
        //System.out.println(prime + " 10001prime");

    }

}
