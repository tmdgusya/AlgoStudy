package BackjunJudge;

import java.util.*;

class FiboZeroOne {
    
    static int[] dp = new int[10];
    static int count_0 = 0;
    static int count_1 = 0;
      
    public static void main(String args[]){
        int T; // Test Case
        int n;
        Scanner scan = new Scanner(System.in);
        dp[0] = 0;
        dp[1] = 1;
        
        T = scan.nextInt();
        for(int i = 0; i<T; i++){
            n = scan.nextInt();
            fibonacci(n);
            System.out.print(count_0);
            System.out.println(count_1);
            count_0 = 0;
            count_1 = 0;
        }

       
    }
    
    static int fibonacci(int n){
        if(n == 0) {
            count_0++;
            return 0;
        }
        if(n == 1){
            count_1++;
            return 1;
        }
        if(dp[n] != 0) return dp[n];
        return dp[n] = fibonacci(n-1) + fibonacci(n-2);
    }
}