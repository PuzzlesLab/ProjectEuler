/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulerproblem12;

/**
 *
 * @author Chia Yi
 */
public class EulerProblem12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*int N=1;
        int sum=0;
        int count=0;
        long end=999999999999999999L;
        for(int i=8; i<end; i++){
            for(i=0; i<=N; i++){
                sum+=i;
            }
            //System.out.println("Sum is " + sum);
            for(int j=1; j<=sum; j++){
                if(sum%j==0){
                    //System.out.println(j + ", ");
                    count++;
                }
            }
            System.out.println("Count is " + count);
            if(count>=500){
                //System.out.println("Count is " + count);
                //System.out.println("Answer is " + sum);
                break;
            }
            N++;
            sum=0;
            count=0;
        }   */
        int num=0;
        for(int i=1; divisor(num)<=500; i++){
            num+=i;
        }
        System.out.println("Ans is " + num);
        
    }
    public static int divisor(int n){
        int count=0;
        for(int i=1; i<Math.sqrt(n); i++){
            if(n%i==0){
                count++;
            }
        }
        count=count*2;
        if(Math.pow(n, 2)==Math.sqrt(n)*Math.sqrt(n)){
            count++;
        }
        System.out.println("Count is " + count);
        return count;
        
    }
    
}
