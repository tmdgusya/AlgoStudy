package BackjunJudge;

import java.util.Scanner;
import java.lang.Math;

public class Back2156 {

    static int[] dp;
    static int[] array;
    static int N;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        dp = new int[N];
        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scan.nextInt();
        }
        if (N >= 1) {
            dp[0] = array[0];
        }
        if (N >= 2) {
            dp[1] = dp[0] + array[1];
        }
        if (N >= 3) {
            dp[2] = Math.max(dp[1], Math.max(array[0] + array[2], array[1] + array[2]));
        }
        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + array[i], dp[i - 3] + array[i - 1] + array[i]));
        }
        System.out.println(dp[N - 1]);
        scan.close();
    }
}
