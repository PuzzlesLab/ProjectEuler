/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe114;

// 2 minutes 5 seconds
public class Pe114 {

    public static long count(int a){
        return count(a,true)+count(a,false);
    }

    //bigBlock for current block (True/False)
    public static long count(int n,boolean bigBlock){
        if(n==0)
            return 1;
        if(n<=2){
            if(!bigBlock)
                return 1;
            return 0;
        }
        if(n==3)
            return 1;
        if(!bigBlock){
            long sum = 0;
            for(int r=1;r<=n;r++){
                //r is the number of small block
                sum += count(n-r,true);
            }
            return sum;
        }else{
            long sum = 0;
            for(int r=3;r<=n;r++){
                sum += count(n-r,false);
            }
            return sum;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(count(50));
    }
   
}
