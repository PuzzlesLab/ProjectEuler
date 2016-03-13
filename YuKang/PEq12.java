/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peq12;

/**
 *
 * @author User
 */
public class PEq12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long i = 0;
        int counter = 1;
        long sum = 0;
        long a=1;
        boolean x = true;
        while(x==true){
            counter = 0;
            i+=a;
            System.out.println(i);
            for (int j = 1; j <= i; j++) {
                if(i%j==0){
                    counter+=1;
                }
            }
            if(counter>500){
                System.out.println("Value : "+i);
                x=false;
            }
            a++;
        }
    }
    
}
