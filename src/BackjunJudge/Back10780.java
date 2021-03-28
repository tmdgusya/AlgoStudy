package BackjunJudge;

import java.util.Scanner;

public class Back10780 {

    static Integer[] dp;
    static int N;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        dp = new Integer[N];
        System.out.print(fibonacci(N));
    }

    public static Integer fibonacci(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(dp[n] != null) {
            return dp[n];
        }
        return dp[n] = fibonacci(n-1) + fibonacci(n-2);
    }

}
