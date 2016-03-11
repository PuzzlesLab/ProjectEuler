/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2;

/**
 *
 * @author GOH
 */
public class P2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] num = new int [2];
        num[0]=1;
        num[1]=2;
        int counter=0;
        int sum=0;
        int evensum=2;
        
        while(sum<4000000)
        {
            sum=num[0]+num[1];
            if(sum%2==0)
            {
                evensum+=sum;
            }
            if(counter==0)
            {
                num[0]=sum;
                counter=1;
            }
            else if(counter==1)
            {
                num[1]=sum;
                counter=0;
            }
            //System.out.println(sum);
        }
        System.out.println("sum : "+evensum );
    }
}
    

