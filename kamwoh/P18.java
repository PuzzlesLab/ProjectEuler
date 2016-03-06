

package projecteuler;

/**
 *
 * @author Woh
 */
public class P18 {
    private static int index=0;
    private static int x=0;
    private static int y=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s1 = "75\n" +
                    "95 64\n" +
                    "17 47 82\n" +
                    "18 35 87 10\n" +
                    "20 04 82 47 65\n" +
                    "19 01 23 75 03 34\n" +
                    "88 02 77 73 07 63 67\n" +
                    "99 65 04 28 06 16 70 92\n" +
                    "41 41 26 56 83 40 80 70 33\n" +
                    "41 48 72 33 47 32 37 16 94 29\n" +
                    "53 71 44 65 25 43 91 52 97 51 14\n" +
                    "70 11 33 28 77 73 17 78 39 68 17 57\n" +
                    "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
                    "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
                    "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
         int[][] n = getInput(s1);
        int[] n1;
        for(int i=n.length-2;i>=0;i--)
        {
            n1 = row(n,i);
            n[i] = n1;
        }
        //display(n);
        System.out.println("total:"+n[0][0]);
    }
    
    //get the row highest and the index
    public static int[] row(int[][] n, int i)
    {
        int[] temp = new int[n[i].length];
        for(int ii=0;ii<n[i+1].length-1;ii++)
        {
            temp[ii]=n[i][ii]+max(n[i+1][ii],n[i+1][ii+1]);
        }
        
        return temp;
    }
   
    public static int max(int n1, int n2)
    {
        if(n1>n2)
            return n1;
        else
            return n2;
    }
 
    public static int[][] getInput(String s1)
    {
        String[] perline = s1.split("\n");
        
        String[][] tokenperline = new String[perline.length][];
        int[][] number = new int[perline.length][perline.length];
        for(int i=0;i<perline.length;i++)
        {
            tokenperline[i]=perline[i].split(" ");
            //number[i] = new int[i+1];
            for(int j=0;j<tokenperline[i].length;j++)
            {
                number[i][j] = Integer.parseInt(tokenperline[i][j]);
                //System.out.print(number[i][j]+" ");
            }
            //System.out.println("");
        }
        return number;
    }
    
    public static void display(int[][] n)
    {
        for(int i=0;i<n.length;i++)
        {
            for(int j=0;j<n[i].length;j++)
            {
                System.out.print(n[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
