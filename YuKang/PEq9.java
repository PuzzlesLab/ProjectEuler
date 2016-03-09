/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peq9;

/**
 *
 * @author User
 */
public class PEq9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int ans = 0;
        int a,b,c = 1;
        
        boolean x = true;
            for (c = 1; c <100000 && x == true; c++) {
                b=1;
                for (b = 1; b < c && x == true; b++) {
                    a=1;
                    for (a = 1; a < b && x == true; a++) {
//                        System.out.println("running");
                        int mA = a*a;
                        int mB = b*b;
                        int mC = c*c;
                        if(mA+mB==mC){
                        System.out.println("running "+mA + " + " + mB + " = " + mC );
                        ans = a+b+c;   
                        if(ans==1000){
                            
                            System.out.println(a+ " + " + b + " + " + c +" = "+ans);
                            System.out.println("Product"+a*b*c);
                            x= false;
                            
                        }
//                        System.out.println(mA + " + " + mB + " + " + mC +" = "+ans);
                       
                    }
                    
                }
                
            }
            
        }
    }
    
}
