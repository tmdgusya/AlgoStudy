package BackjunJudge;

import java.util.Scanner;
import java.lang.Math;

class Back1932 {

    // 이거 제대로 이해하려면 재귀를 이해해야함.
    static int N;
    static int[][] dp;
    static int[][] value;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        value = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                value[i][j] = scan.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = value[N - 1][i];
        }
        System.out.println(search(0, 0));
        scan.close();
    }

    static int search(int depth, int idx) {
        if (depth == N - 1) {
            return dp[depth][idx];
        }

        if (dp[depth][idx] == 0) {
            dp[depth][idx] = Math.max(search(depth + 1, idx), search(depth + 1, idx + 1)) + value[depth][idx];
        }
        return dp[depth][idx];
    }
}