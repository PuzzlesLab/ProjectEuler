/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulerproblem14;

/**
 *
 * @author Chia Yi
 */
public class EulerProblem14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long num;
        long count=1;
        long max=0;
        long current=0;
        for(int i=13; i<1000000; i++){
            num=i;
            while(num!=1){
                if(num%2==0){
                    num=num/2;
                    count++;
                }
                else{
                    num=(3*num)+1;
                    count++;
                }
            }
            if(count>max){
                max=count;
                current=i;
            }
            
        }
        
            System.out.println("Count " + count);
            System.out.println("Number " + current);
        
        
        
        
    }
    
}
