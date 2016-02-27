/**
 *
 * @author Shahin
 */
public class Problem1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int prev1=0,prev2=1,temp=prev1+prev2,sum=0;
        
        while(true){
            if(temp>4000000){
                break;
            }
            if(temp%2==0){
                sum+=temp;
	    }
            prev1=prev2;
            prev2=temp;
            temp=prev1+prev2;
        }  
        System.out.println(""+sum);
    }
    
}

