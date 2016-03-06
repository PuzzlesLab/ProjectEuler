/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulerproblem4;

/**
 *
 * @author Chia Yi
 */
public class EulerProblem4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int ans;
        int identity;
        int sum=0;
        int max=0;
        for(int i=100; i<=999; i++){
            for(int j=100; j<=999; j++){
                ans=i*j;
                //System.out.println(i + " * " + j + " = " + ans);
                identity=ans;
                //System.out.println("Isit the same as the answer? " + identity);
                while(identity>1){
                    sum=(sum*10)+(identity%10);
                    identity=identity/10;
                    
                }
                if(sum==ans){
                    if(ans>max){
                        max=ans;
                    }
                    //System.out.println("you've found it" + ans + " = " + i + " * " + j ); 
                }
                sum=0;
                
            }
        }
        System.out.println("The real answer is " + max);
        
                
    }
    
}
