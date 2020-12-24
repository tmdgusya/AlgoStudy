package BackjunJudge;

import java.util.Scanner;

class Back2193 {
    
    static int N;
    static long[] dp;
    // fibonacci 같은건 배열을 long 형태로 해주는게 좋음 int 형을 잘벗어나기때문에
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        dp = new long[N+1];
        dp[0] = 1;
        dp[1] = 1;
        System.out.println(find(N));
    }
    
    static long find(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(dp[n] != 0) return dp[n];
        dp[n] = find(n-2) + find(n-1);
        return dp[n];
    }
}