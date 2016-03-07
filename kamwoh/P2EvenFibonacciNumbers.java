
package projecteuler;

import java.util.ArrayList;


public class P2EvenFibonacciNumbers 
{

    public static ArrayList<Integer> store = new ArrayList<>();
    public static int[] ss = new int[100];
    
    public static void main(String[] args) 
    {
        int x,y,z=0;
        x=1;
        y=2;
        int total=0;
        z = 0;
        int index=0;
        long before = System.currentTimeMillis();
        while(z<4000000)
        {
            z = fib(index);
            ss[index]=z;
            if(z%2==0)
                total+=z;
            index++;
        }
        
        long after = System.currentTimeMillis();
        System.out.println(after - before +" ms");
        
        System.out.println(total);
        total=0;
        
        
            while(y<4000000)
            {/*
            x=z;
            z=z+y;
            System.out.println("Z "+ z);
           
            y=z;
            z=z+x;
            System.out.println("Z "+ z);
         */
                if(y%2==0)
                    total+=y;
                y = x+y;
                x = y-x;
                //System.out.println("y " + y);
                //System.out.println("x " + x);
                //x = y-x;
                //System.out.println("x " + x);
                
            }
            System.out.println("Total "+total);
            System.out.println(System.currentTimeMillis()-after+ " ms");
        }
    
    public static int fib(int n)
    {
        if(n==0)
            return 1;
        
        if(n==1)
            return 2;
        
        if(ss[n]!=0)
            return ss[n];
        
        return fib(n-1)+fib(n-2);
    }

}
