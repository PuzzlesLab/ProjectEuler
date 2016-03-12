package pe61;

//13ms 121 line
//7ms  101 line
public class Pe61 {

    public static int [][] polygonal = new int[9][200];
    public static int [] count = new int[140];
    public static int [] num = new int[9];
    public static int sum = 0;
    
    public static boolean check(int n){
        if(n>999&&n<10000&&n%10!=0&&n%100>9)
            return true;
        return false;
    }
    
    public static boolean next(int a,int b){
        if(a%100==b/100)
            return true;
        return false;
    }
    
    public static void cycle(int first,int last,boolean use[],int n){
        if(n==3){
            //cyclic number set can be rotate
            //setting triangular as first of cyclic number set
            for(int i=1;i<=count[3];i++){
                int next = polygonal[3][i];
                num[n] = next;
                cycle(next,next,use,n+1);
            }
        }else{
            for(int f=4;f<=8;f++){
                if(!use[f]){
                    for(int i=1;i<=count[f];i++){
                        int next = polygonal[f][i];
                        if(next(last,next)){
                            num[n] = next;
                            use[f] = true;
                            if(n==8){
                                if(next(next,first)){
                                    sum += num[3]+num[4]+num[5]+num[6]+num[7]+num[8];
                                    System.out.println(num[3]+" "+num[4]+" "+num[5]+" "+num[6]+" "+num[7]+" "+num[8]);
                                }
                                use[f] = false;
                            }
                            else{
                                cycle(first,next,use,n+1);
                            }
                        }    
                        use[f] = false;
                    }
                }                    
            }
        }
    }
    
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        int tri,sq,pen,hex,hep,oct;
        boolean use[] = new boolean[9];
        
        for(int n=1;n<=1000;n++){
            tri = (n*(n+1))/2;
            if(check(tri))
                polygonal[3][++count[3]]=tri;
            sq = n*n;
            if(check(sq))
                polygonal[4][++count[4]]=sq;
            pen = (n*(3*n-1))/2;
            if(check(pen))
                polygonal[5][++count[5]]=pen;
            hex = n*(2*n-1);
            if(check(hex))
                polygonal[6][++count[6]]=hex;
            hep = (n*(5*n-3))/2;
            if(check(hep))
                polygonal[7][++count[7]]=hep;
            oct = n*(3*n-2);
            if(check(oct))
                polygonal[8][++count[8]]=oct;
        }
          
        cycle(0,0,use,3);
        System.out.println(sum);
        System.out.println(System.currentTimeMillis()-before+" ms");
    }    
}
