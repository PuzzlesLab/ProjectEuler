/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulerproblem3;

/**
 *
 * @author Chia Yi
 */
public class EulerProblem3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num=2;
        boolean flag=true;
        long ans=600851475143L;
        long max=0;
        //System.out.println(2 +", ");
        while(num<=ans){
            for(int i=2; i<num; i++){
                if(num%i==0){
                    flag=false;
                    num++;
                    break;
                }
                flag=true;
            
            } 
           if(flag==true){
               if(ans%num==0){
                   System.out.println("Prime factor is " + num);
                   max=num;
                   System.out.println("Largest prime factor is " + max);
                   
               }
                //System.out.println(num + ", ");
                num++;
            }
        }
        
        
        
        
        
        
        
    }
    
}
