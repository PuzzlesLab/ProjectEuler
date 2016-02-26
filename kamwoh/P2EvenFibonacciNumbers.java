
package projecteuler;


public class P2EvenFibonacciNumbers 
{

    public static void main(String[] args) 
    {
        int x,y,z=0;
        x=1;
        y=2;
        int total=0;
        
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
                System.out.println("y " + y);
                System.out.println("x " + x);
                x = y-x;
                System.out.println("x " + x);
                
            }
            System.out.println("Total "+total);
        }
    

}
