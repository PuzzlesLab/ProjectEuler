/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulerproblem5;

/**
 *
 * @author Chia Yi
 */
public class EulerProblem5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num=1;
        boolean flag=true;
        for(int j=21; j<1000000000; j++){
            //System.out.println("Current number " + j);
            for(int i=1; i<=20; i++){
                //System.out.println("Operation - " + j + " % " + i + " = ");
                if(j%i!=0){
                    flag=false;
                    break;
                }
                flag=true;
            
            }
            if(flag==true){
                System.out.println("The number is " + j);
            }
        }
        
    }
    
}
