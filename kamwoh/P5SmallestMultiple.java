
package projecteuler;


public class P5SmallestMultiple 
{

    public static void main(String[] args) 
    {
        /*int number=20;
		boolean flag;
		do {
			flag=true;
			for (int i=11;i<=20;i++) 
                        {
				flag = flag && (number%i==0);
			}
			if (!flag) {
				number+=20;
			}
		} while (!flag);
		System.out.println(number);*/
        int positivenumber=20;
        int count=0;
        boolean check=false;
        
        while(check!=true)
        {
        for(int i=11;i<=20;i++)
        {
            if(positivenumber%i==0)
            {
                count++;
                //System.out.println("positive " + positivenumber);
            }
        }
            //System.out.println("count " + count);
        if (count==10)
        {
            //System.out.println(positivenumber + " yes");
            check=true;
        }
        /*else
        {
            System.out.println(positivenumber + " no");
            
        }*/
        positivenumber+=20;
        count=0;
        
        }
        System.out.println(positivenumber);
    }
}
