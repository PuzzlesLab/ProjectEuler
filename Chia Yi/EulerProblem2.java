/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulerproblem2;

/**
 *
 * @author Chia Yi
 */
public class EulerProblem2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int f0=0;
        int f1=1;
        int fn=f0+f1;
        int sum=0;
        System.out.println("The terms are");
        while(fn<4000000){
            System.out.println(fn + ", ");
            f0=f1;
            f1=fn;
            fn=f0+f1;
            if(fn%2==0){
                sum+=fn;
                
            }
        }
        System.out.println("Sum is " + sum);
        
    }
    
}
