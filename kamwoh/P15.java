

package projecteuler;

/**
 *
 * @author Woh
 */
public class P15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long[][] grid = new long[21][21];
        int total=0;
        
        //cal possible way
        for(int i=0;i<grid.length;i++)
        {
            grid[i][grid.length-1]=1;
            /*for(int a=0;a<grid.length;a++)
            {
                for(int b=0;b<grid[a].length;b++)
                    System.out.print(grid[a][b]+" ");
                System.out.println("");
            }
            System.out.println("");*/
        }
        
        for(int i=0;i<grid.length;i++)
        {
            grid[grid.length-1][i]=1;
            /*for(int a=0;a<grid.length;a++)
            {
                for(int b=0;b<grid[a].length;b++)
                    System.out.print(grid[a][b]+" ");
                System.out.println("");
            }
            System.out.println("");*/
        }
        
        for(int i=grid.length-2;i>=0;i--)
        {
            for(int j=grid.length-2;j>=0;j--)
            {
                grid[i][j]=grid[i][j+1]+grid[i+1][j];
                /*for(int a=0;a<grid.length;a++)
                {
                    for(int b=0;b<grid[a].length;b++)
                        System.out.print(grid[a][b]+" ");
                    System.out.println("");
                }
                System.out.println("");*/
            }
        }
        //cal total
        /*for(int a=0;a<grid.length;a++)
        {
            for(int b=0;b<grid[a].length;b++)
                System.out.print(grid[a][b]+" ");
            System.out.println("");
        }*/
        
        System.out.println("total: "+grid[0][0]);
    }
}
