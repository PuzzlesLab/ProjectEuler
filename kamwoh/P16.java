
package projecteuler;


public class P16 {
    
    public static void newArray(int[] target)
    {
        int size = target.length;
        if(target[size-1]!=0)
            {
                size*=2;
                int[] temparray = new int[size];
                System.arraycopy(target, 0, temparray, 0, target.length);
                target = new int[size];
                System.arraycopy(temparray, 0, target, 0, temparray.length);
            //System.out.println(answer[2]+" "+answer[1]+" "+answer[0]);
            }
    }
    
    
    public static void selfPower(int[] target, int times)
    {
        for(int i=1;i<=times;i++)
            for(int x=target.length-1;x>=0;x--)
            {
                target[x]*=times;
            }
    }
    public static void main(String[] args)
    {
        //array a = new array();
        int size=2;
        int x;
        int[] answer=new int[2];
        int temp;
        answer[0]=1;
        for(int i=1;i<=1000;i++)
        {
            for(x=size-1;x>=0;x--)
            {
                answer[x]*=2;
                
                if(answer[x]>=10)
                {
                    temp=answer[x]/10;
                    answer[x+1]+=temp;
                    answer[x]%=10;
                }
                //System.out.println(answer[2]+" "+answer[1]+" "+answer[0]);
                
                //System.out.println(answer[1]+" "+answer[0]);
            }
            if(answer[size-1]!=0)
            {
                size*=2;
                int[] temparray = new int[size];
                System.arraycopy(answer, 0, temparray, 0, answer.length);
                answer = new int[size];
                System.arraycopy(temparray, 0, answer, 0, temparray.length);
            //System.out.println(answer[2]+" "+answer[1]+" "+answer[0]);
            }
        }
        //int count=0;
        int total=0;
        for(int i=answer.length-1;i>=0;i--)
        {
            //if(answer[i]!=0)
            {
                //System.out.print(answer[i]);
                total+=answer[i];
                //count++;
            }
        }
        //System.out.println("");
        //System.out.println(count);
        System.out.println("");
        System.out.println(total);
    }
}