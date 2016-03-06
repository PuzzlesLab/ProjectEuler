/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulerproblem9;

/**
 *
 * @author Chia Yi
 */
public class EulerProblem9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double last=0;
        double ans;
        double product;
        while(last<=1000){
            for(int a=1; a<=1000; a++){
                for(int b=1; b<=1000; b++){
                    for(int c=2; c<=1000; c++){
                       ans=Math.pow(a, 2)+Math.pow(b, 2); 
                       if(ans==Math.pow(c,2)){
                           last=a+b+c;
                           if(last==1000){
                               System.out.println("A is " + a);
                               System.out.println("B is " + b);
                               System.out.println("C is " + c);
                               product=a*b*c;
                               System.out.println("Product is " + product);
                               break;
                           }
                       }
                    }
                }
            }
        }
        
    }
    
}
