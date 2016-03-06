
package projecteuler;


public class P9SpecialPythagorenTriplet 
{
    
    public static void main(String[] args) 
    {
        boolean check=false;
        int a=0,b=0,sqc=0,c=0;
        for(b=1;b<1000;b++)
        {
            for(a=1;a<b;a++)
            {
                sqc = a*a+b*b;
                c = (int)Math.sqrt(sqc);
                if(sqc==c*c&&a+b+c==1000)
                {
                        System.out.println(a+" "+b+" "+c);
                        check = true;
                }
                if(check)
                    break;
            }
            if(check)
                break;
        }
        
        long answer = a*b*c;
        System.out.println(answer);
    }
}
