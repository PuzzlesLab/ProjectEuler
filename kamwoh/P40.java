
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
        System.out.println("");
        
        int total=1; //D1 0
        int n = 0;
        int l = 1;
        int size = 1;
        int count = 1; // 1 is known as D 1
        System.out.println(total+" "+(n+1));
        int formula;
        String s;
        int temp;
        int index;
        long before = System.currentTimeMillis();
        while(n<=1000000)
        {
            n+=size;
            l++;
            formula = (int)Math.pow(10, count);
            if(l>=formula)
                size=++count;
            
            if(n>=formula-size&&n<=formula)
            {
                System.out.println(l+" "+(n+1));
                s = String.valueOf(l);
                temp = n+1;
                index = 0;
                while(temp!=formula)
                {
                    temp++;
                    index++;
                    //System.out.println(temp+" t");
                }
                total*=Integer.parseInt(""+s.charAt(index));
            }
        }
        System.out.println(total);
        System.out.println("time:"+(System.currentTimeMillis()-before));
    }
}
