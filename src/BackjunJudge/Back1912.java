package BackjunJudge;

import java.util.Scanner;
import java.lang.Math;

public class Back1912 {

    static Integer dp[]; // [depth][idx]
    static int array[];

    static int max;

    public static void main(String[] args) {
        // 이전까지 더했던 것들보다 앞에게 더큰지 비교하고, 그 뒤에걸 풀어냄
        Scanner scan = new Scanner(System.in);
        int N;
        N = scan.nextInt();
        dp = new Integer[N];
        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scan.nextInt();
        }

        dp[0] = array[0];
        max = array[0];
        recur(N - 1);
        scan.close();
        System.out.println(max);
    }

    static int recur(int N) {
        if (dp[N] == null) { // 이게 Integer 로 되어야 하는 이유는 0 이랑 null 은 분명다르기때문
            dp[N] = Math.max(recur(N - 1) + array[N], array[N]);
            System.out.println("dp[N] = " + dp[N]);
            max = Math.max(max, dp[N]);
            System.out.println("Max = " + max);
            System.out.println("======================");
        }
        return dp[N];
    }
}
