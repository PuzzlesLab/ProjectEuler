
package projecteuler;


public class P26B {

    public static void main(String[] agrs)
    {//00101729399796
        String s = divide(1000,"1","983");
        System.out.println(s);
    }
    
    public static String divide(int scale, String a,String b)
    {
        String ans="";
        
        int aa = Integer.parseInt(a);
        int bb = Integer.parseInt(b);
        int cc;
        int remainder;
        for(int i=0;i<scale;i++)
        {
            cc = aa/bb;
            remainder = aa%bb;
            ans += ""+cc;
            if(cc*bb==aa)
                break;
            remainder*=10;
            aa = remainder;
        }
        
        ans = "0."+ans.substring(1);
        return ans;
    }
    
}
