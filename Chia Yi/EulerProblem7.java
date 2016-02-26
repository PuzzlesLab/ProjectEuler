/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulerproblem7;

/**
 *
 * @author Chia Yi
 */
public class EulerProblem7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int count=1;
        int num=2;
        boolean flag=true;
        while(count<=10001){
            for(int i=2; i<num; i++){
                if(num%i==0){
                    flag=false;
                    num++;
                    break;
                }
                flag=true;
            }
            if(flag==true){
                count++;
                if(count==10001){
                    System.out.println("The answer is " + num);
                }
                System.out.println("Prime are " + num);
                num++;
            }
            
        }
        
        
    }
    
}
