/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peq10;

/**
 *
 * @author User
 */
public class PEq10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long sum = 0;
        for (int i = 1; i < 2000000; i+=2) {
            int counter = 0;
            if(i%2!=0){
            for (int j = 1; j <= i; j++) {
                if(i%j==0){
                    counter+=1;
                }
                
                
            }
            if(counter == 2){
                System.out.println("Prime : "+i);
                sum+=i;
            }
            }
        }
        System.out.println("Sum : "+sum);
    }
    
}
