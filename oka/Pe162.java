package pe162;

import java.math.BigInteger;
public class Pe162 {
    //Let S0 be the number consist of digit '0', but without '1' or 'A'
    //Let S1 be ...
    //Let SA be ...
    //S0_AND_S1 mean the 'each' number consist of digit ('0' and '1') and without 'A'
    //S0_OR_S1 mean the number consist of digit '0','1' and without 'A'
    //use BigInteger # use long will overflow =.=
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        BigInteger X_S0 [] = new BigInteger[17];
        BigInteger X_S1 [] = new BigInteger[17];
        BigInteger X_SA [] = new BigInteger[17];
        
        BigInteger X_S0_AND_S1 [] = new BigInteger[17];
        BigInteger X_S0_AND_SA [] = new BigInteger[17];
        BigInteger X_S1_AND_SA [] = new BigInteger[17];
        
        BigInteger X_S0_OR_S1 [] = new BigInteger[17];
        BigInteger X_S0_OR_SA [] = new BigInteger[17];
        BigInteger X_S1_OR_SA [] = new BigInteger[17];
        
        BigInteger X_S0_AND_S1_AND_SA [] = new BigInteger[17];
        BigInteger X_S0_OR_S1_OR_SA [] = new BigInteger[17];
        
        X_S0[1] = BigInteger.ZERO;
        X_S1[1] = BigInteger.ONE;
        X_SA[1] = BigInteger.ONE;
        
        X_S0_OR_S1[1] = BigInteger.ONE;
        X_S0_OR_SA[1] = BigInteger.ONE;
        X_S1_OR_SA[1] = new BigInteger("2");
        
        X_S0_OR_S1_OR_SA[1] = new BigInteger("2");
        
        BigInteger total = BigInteger.ZERO;
        
        for(int i=2;i<=16;i++){
            X_S0[i] = new BigInteger("13").multiply(X_S0[i-1]).add(new BigInteger("13").multiply(new BigInteger("14").pow(i-2)));
            X_S1[i] = new BigInteger("14").pow(i-1).add(new BigInteger("13").multiply(X_S1[i-1]));
            X_SA[i] = X_S1[i];
            
            X_S0_OR_S1[i] = new BigInteger("15").pow(i-1).add(new BigInteger("13").multiply(X_S0_OR_S1[i-1])).add(new BigInteger("13").multiply(new BigInteger("15").pow(i-2)));
            X_S0_OR_SA[i] = X_S0_OR_S1[i];
            X_S1_OR_SA[i] = new BigInteger("2").multiply(new BigInteger("15").pow(i-1)).add(new BigInteger("13").multiply(X_S1_OR_SA[i-1]));
            
            X_S0_AND_S1[i] = X_S0_OR_S1[i].subtract(X_S0[i]).subtract(X_S1[i]);
            X_S0_AND_SA[i] = X_S0_AND_S1[i];
            X_S1_AND_SA[i] = X_S1_OR_SA[i].subtract(X_S1[i]).subtract(X_SA[i]);
            
            X_S0_OR_S1_OR_SA[i] = new BigInteger("2").multiply(new BigInteger("16").pow(i-1)).add(new BigInteger("13").multiply(X_S0_OR_S1_OR_SA[i-1])).add(new BigInteger("13").multiply(new BigInteger("16").pow(i-2)));
            
            X_S0_AND_S1_AND_SA[i] = X_S0_OR_S1_OR_SA[i].subtract(X_S0_AND_S1[i]).subtract(X_S0_AND_SA[i]).subtract(X_S1_AND_SA[i])
                                    .subtract(X_S0[i]).subtract(X_S1[i]).subtract(X_SA[i]);
            
            total = total.add(X_S0_AND_S1_AND_SA[i]);
        }
        
        System.out.println(total.toString(16).toUpperCase());
        System.out.println((System.currentTimeMillis()-before)+" ms.");
    }
    
}
