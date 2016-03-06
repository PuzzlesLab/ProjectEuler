
package projecteuler;


public class P40 {

    public static void v1()
    {
        int count=1;
		int length;
        String s="";
        while(s.length()<=1000000)
        {
            s+=""+count;
            count++;
            //System.out.println(s);
        }
        
        long ans=1;
        for(int i=1;i<7;i++)
        {
            ans*=Integer.parseInt(""+s.charAt((int)Math.pow(10, i)-1));
        }
        System.out.println(s.charAt(0)+" "+s.charAt(99)+" "+s.charAt(999)+" "+s.charAt(9999)+" "+s.charAt(99999)+" "+s.charAt(999999));
        
        System.out.println(s);
        System.out.println(ans);
    }
    
    public static void main(String[] args)
    {
        //v1();
        zzzz();
        System.out.println("");
        int total=0;
        int last;
        /*
        while(total<=1000000)
        {
            last = total;
            
        }*/
        
    }
    
    public static void zzzz()
    {
        int total=0;
        int n;
        int last;
        int count = 0;
        while(total<=1000000)
        {
            
            last = total;
            n=9*(int)Math.pow(10, count)*(count+1);
            total+=n;
            System.out.println("1"+z(count)+" to "+"9"+z1(count));
            count++;
            System.out.println("n "+n+" total "+ (last+1) +" "+total);
        }
    }
    
    public static int check(int start)
    {
        return 0;
    }
    
    public static String z1(int n)
    {
        String s ="";
        for(int i=0;i<n;i++)
        {
            s+=""+9;
        }
        return s;
    }
    
    public static String z(int n)
    {
        String s = "";
        for(int i=0;i<n;i++)
        {
            s+=""+0;
        }
        return s;
    }
}
