

package projecteuler;

/**
 *
 * @author Woh
 */
public class P24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String n = "0123456789";
        long[] a = new long[10];
        int count =0;
        int ans1;
        String ans="";
        boolean check = false;
        long n1 = f(9);
        long n2=0;
        long n3 = f(9)*3-88640;
        System.out.println("index start from 2:"+(n1*2+1)+" to 1088640");
        System.out.println(f(9)*2+f(8)*6+f(7)*6+f(6)*2+f(5)*5+f(4)*1+f(3)*2+f(2)*1+f(1)*1+f(0)*1);
        
        for(int i=9;i>=0;i--)
        {
            for(int j=1;j<=9;j++)
            {
                n2=f(i)*j;
                if(n2>=n3)
                {
                    n2=f(i)*(j-1);
                    n3-=n2;
                    System.out.println("n2 "+n2);
                    System.out.println("n3 "+n3);
                    System.out.println("f("+i+")*"+(j-1));
                    ans+=n.charAt(j-1);
                    if(n.length()>1)
                        n=n.substring(0, j-1)+n.substring(j, n.length());
                    System.out.println("ans "+ans);
                    System.out.println("n "+n);
                    check = true;
                    break;
                }
            }
            if(check)
            {
                a[count]=n2;
                System.out.println("a "+a[count]);
                System.out.println("");
                count++;
                check=false;
            }
        }
        
        System.out.println(n2);
        
        System.out.println(ans);
    }

    
    public static long f(int n)
    {
        
        if(n==0||n==1)
            return 1;
        else
            return n*f(n-1);
    }
    
    public static void remove(int[] array, int index)
    {
        
    }
}
