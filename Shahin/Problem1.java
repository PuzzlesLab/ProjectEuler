/*
 * Shahin

 */
package javaapplication1;

public class Problem1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int sum=0;
        
        for (int i = 0; i < 100; i++) {
            if(i%3==0 || i%5==0){
                sum+=i;
            }
        }
        System.out.println(""+sum);
    }
    
}
