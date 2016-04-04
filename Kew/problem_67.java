import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.ArrayList;

public class problem_67
{
    public static void main(String[]args)
    {
        long before=System.currentTimeMillis();
        Scanner fin=null;
        ArrayList<String>content=new ArrayList<>();
        try
        {
            fin=new Scanner(new FileInputStream("p067_triangle.txt"));
            while(fin.hasNextLine())
            {
                content.add(fin.nextLine());                
            }
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            if(fin!=null)
                fin.close();
        }

        //System.out.println(content);       

        //add sum
        int[]sum=new int[100];
        String[]s=content.get(content.size()-1).split(" ");
        for(int i=0;i<s.length;i++)
        {
            sum[i]=Integer.parseInt(s[i]);
        }
        //end adding sum

        int[][]n=new int[100][100];
        for(int i=0;i<content.size();i++)
        {
            String[]t=content.get(i).split(" ");
            for(int j=0;j<t.length;j++)
            {
                n[i][j]=Integer.parseInt(t[j]);
            }
        }

        //int[][]n={{3},{7,4},{2,4,6},{8,5,9,3}};
        
        /*int[][]n={{75},{95,64},{17,47,82},{18,35,87,10},{20,04,82,47,65},{19,01,23,75,03,34}
        ,{88,02,77,73,07,63,67},{99,65,04,28,06,16,70,92},{41,41,26,56,83,40,80,70,33},{41,48,72,33,47,32,37,16,94,29},{53,71,44,65,25,43,91,52,97,51,14}
        ,{70,11,33,28,77,73,17,78,39,68,17,57},{91,71,52,38,17,14,91,43,58,50,27,29,48},{63,66,04,68,89,53,67,30,73,16,69,87,40,31},{04,62,98,27,23,9,70,98,73,93,38,53,60,04,23}};*/
        //int[]sum={04,62,98,27,23,9,70,98,73,93,38,53,60,04,23};
        //int[]sum={8,5,9,3};
        int index=0;

        //System.out.println("n length="+n.length);


        for(int i=n.length-2;i>=0;i--)
        {
            for(int j=0;j<n[i].length;j++)
            {
                if(n[i][j]==0)
                {
                    break;
                }
                int max=0;
                for(int k=0;k<2;k++)
                {                               
                    int temp=sum[index+k]+n[i][j];
                    /*System.out.println("index+k="+(index+k));
                    System.out.println("sum[index+k]="+sum[index+k]);
                    System.out.println("n[i][j]="+n[i][j]);
                    System.out.println("temp="+temp);
                    System.out.println("max="+max);*/
                    if(temp>max)
                        max=temp;                    
                }                
                sum[index]=max;
                //System.out.println("");
                //System.out.println("sum[index]="+sum[index]);
                index++;
            }
            index=0;
        }
        int max=0;
        for(int i=0;i<sum.length;i++)
        {
            if(sum[i]>max)
                max=sum[i];
        }

        System.out.println("max = "+max);
        long after=System.currentTimeMillis();
        System.out.println("Time Taken: "+(after-before)+"ms");

    }    
}