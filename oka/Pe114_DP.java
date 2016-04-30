/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe114_dp;

public class Pe114_DP {

    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        long s[][] = new long[51][2];
        //s[m][n] 
        //n=0 for small block
        //n=1 for bigblock
        s[0][0] = 1;  s[0][1] = 1;
        s[1][0] = 1;  s[1][1] = 0;
        s[2][0] = 1;  s[2][1] = 0;

        for(int i=3;i<=50;i++){
            for(int j=1;j<=i;j++){
                s[i][0] += s[i-j][1];
            }
            for(int j=3;j<=i;j++){
                s[i][1] += s[i-j][0];
            }
        }
        //count(0) != s[0][0]+s[0][1]
        //count(n) =  s[n][0]+s[n][1]
        System.out.println(s[50][0]+s[50][1]);
        System.out.println(System.currentTimeMillis()-before+" ms.");
    }
    
}
