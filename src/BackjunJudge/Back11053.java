package BackjunJudge;

import java.util.Scanner;
import java.lang.Math;

public class Back11053 {

    static Integer dp[];
    static int array[];
    static int N;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        array = new int[N];
        dp = new Integer[N];

        for (int i = 0; i < N; i++) {
            array[i] = scan.nextInt();
        }

        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }

        System.out.println(max);
        scan.close();
    }
}
