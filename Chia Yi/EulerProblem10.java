/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulerproblem10;

/**
 *
 * @author Chia Yi
 */
public class EulerProblem10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        boolean[]isPrime=new boolean[2000000];
        for(int i=2; i*i<isPrime.length; i++){
            if(!isPrime[i]){
                for(int j=i*i; j<isPrime.length; j+=i){
                    isPrime[j]=true;
                }
            }
        }
        long sum=0;
        for(int i=2; i<isPrime.length; i++){
            if(!isPrime[i]){
                System.out.println(i);
                sum+=i;
            }
        }
        System.out.println("Sum is " + sum);
                
        /*long sum=0;
        for(int i=2; i<=2000000; i++){
            if(isPrime(i)){
                sum+=i;
            }
        }
        System.out.println("Sum is " + sum);
                
    }
    public static boolean isPrime(int n){
        if(n==2){
            return true;
        }
        else if (n%2==0){
            return false;
        }
        for(int i=3; i*i<=n; i++){
            if(n%i==0){
                return false;
            }
            
        }
        return true;
                */
    }
}
