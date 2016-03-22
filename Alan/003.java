public class Main {
    public static void main(String[] args) {
        prime(600851475143L);
    }
    
    int max = Integer.MAX_VALUE;
    
    public static void prime(long a){
        if (a % 2 == 0)
            a/=2;
        for (long i = 3; i<a; i+=2){
            while(a % i == 0)
                a /= i;
        }
        System.out.println(a);
    }
    
}
