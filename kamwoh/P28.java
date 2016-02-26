

package projecteuler;

/**
 *
 * @author Woh
 */
public class P28 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] n = new int[1001][1001];
        int count1=n.length/2;
        int count2=n.length/2;
        int count=1;
        int round=1;
        boolean up=false;
        boolean down=true;
        boolean right=true;
        boolean left=false;
        int m=0;
        while(round<n.length)
        {
            for(int j=0;j<2;j++)
            {
                for(int i=0;i<round;i++)
                {
                    n[count1][count2]=count;
                    count++;
                    if(right)
                    {
                        count2++;
                        if(i==round-1)
                        {
                            right=false;
                            down=true;
                        }
                    }
                    else if(down)
                    {
                        count1++;
                        if(i==round-1)
                        {
                            left=true;
                            down=false;
                        }
                    }
                    else if(left)
                    {
                        count2--;
                        if(i==round-1)
                        {
                            up=true;
                            left=false;
                        }
                    }
                    else if(up)
                    {
                        count1--;
                        if(i==round-1)
                        {
                            up=false;
                            right=true;
                        }
                    }

                    //System.out.println("round " +j+ " "+round);
                }
            
            }
            round++;
            //System.out.println("round1 "+round);
            
        }
        
        for(int i=0;i<n.length;i++)
        {
            n[0][i]=count;
            count++;
        }
        /*
        for(int i=0;i<n.length;i++)
        {
            for(int j=0;j<n[i].length;j++)
            {
                System.out.print(n[i][j]+" ");
            }
            System.out.println("");
        }*/
        int total=0;
        count1=0;
        count2=n.length-1;
        
        
        
        for(int i=0;i<n.length;i++)
        {
            if(i==n.length/2)
            {
                total+=n[i][i];
                //System.out.println(n[i][i]);
            }
            else
            {
            total+=(n[i][count1]+n[i][count2]);   
            }/*
            System.out.println(n[i][count1]);
            System.out.println(n[i][count2]);*/
            if(i<n.length/2)
            {
                count1++;
                count2--;
            }
            else
            {
                count1--;
                count2++;
            }
            //System.out.println("");
        }
        
        System.out.println("total "+total);
    }

}
