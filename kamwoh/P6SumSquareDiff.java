
package projecteuler;


public class P6SumSquareDiff 
{

    public static void main(String[] args) 
    {
        int sumx=0,sumy=0,diff;
        for(int i=1;i<=100;i++)
        {
            sumx+=i*i;
            sumy+=i;
        }
        sumy=sumy*sumy;
        if(sumy>sumx)
            diff=sumy-sumx;
        else
            diff=sumx-sumy;
        System.out.println("x " +sumx + " y " + sumy + " diff " + diff);

    }

}
