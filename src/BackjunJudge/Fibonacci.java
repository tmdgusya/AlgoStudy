package BackjunJudge;

public class Fibonacci{
    static int[] d = new int[100];
    
    static int fibonacci(int x){
        if(x==1) return 1;
        if(x==2) return 2;
        if(d[x] != 0) return d[x];
        return d[x] = fibonacci(x-1) + fibonacci(x-2);
    }
    
    public static void main(String args[]){
        System.out.println(fibonacci(30));
    }
    
    // static int fibonacci(int n){
    //     if(n==0) return 1;
    //     if(n==1) return 1;
    //     return fibonacci(n-1) + fibonacci(n-2);
    // }
    

    
    
}