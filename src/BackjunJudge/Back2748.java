package BackjunJudge;

import java.util.Scanner;

class Back2748 {

    static Integer[] dp;
    static int N;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        dp = new Integer[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(fibonacci(N));
        scan.close();
    }

    static Integer fibonacci(int n) {
        if (dp[n] != null) {
            return dp[n];
        }
        if (n == 1)
            return 1;
        if (n == 0)
            return 0;
        return dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}