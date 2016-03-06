/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulerproblem6;

/**
 *
 * @author Chia Yi
 */
public class EulerProblem6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int sum=0;
        double squareofSum=0;
        double sumofSquares=0;
        
        for(int i=0; i<=100; i++){
            sum+=i;
        }
        squareofSum=Math.pow(sum, 2);
        System.out.println("Square of the sum " + (int)squareofSum);
        for(int i=0; i<=100; i++){
            sumofSquares+=Math.pow(i, 2);
        }
        double difference=squareofSum-sumofSquares;
        System.out.println("Sum of squares " + (int)sumofSquares);
        System.out.println("Difference is " + (int)difference);
        
    }
    
}
