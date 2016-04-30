/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe115;
public class Pe115 {
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        long s[][] = new long[1000][2];
        //s[m][n] 
        //n=0 for small block
        //n=1 for bigblock
        int m=50;
        s[0][0] = 1;  s[0][1] = 1;
        
        for(int i=1;i<m;i++){
            s[i][0] = 1;
        }

        for(int i=m;;i++){
            for(int j=1;j<=i;j++){
                s[i][0] += s[i-j][1];
            }
            for(int j=m;j<=i;j++){
                s[i][1] += s[i-j][0];
            }
            if(s[i][0]+s[i][1]>1_000_000){
                System.out.println(i);
                System.out.println(s[i][0]+s[i][1]);
                break;
            }
        }
        //count(0) != s[0][0]+s[0][1]
        //count(n) =  s[n][0]+s[n][1]
        System.out.println(System.currentTimeMillis()-before+" ms.");
    }
    
}
