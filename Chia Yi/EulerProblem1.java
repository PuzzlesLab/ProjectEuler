/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euler.problem.pkg1;

/**
 *
 * @author Chia Yi
 */
public class EulerProblem1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i;
        int sum=0;
        System.out.print("The multiples are");
        for(i=0; i<1000; i++){
            if(i%3==0 || i%5==0){
                System.out.println(i + ", ");
                sum+=i;
            }
        }
        System.out.println("The sum is " + sum);
        
        
        
    }
    
}
