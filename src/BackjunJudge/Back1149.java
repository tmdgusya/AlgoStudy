package BackjunJudge;


import java.util.Scanner;

public class Back1149 {

    static int[][] map;
    static Integer[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        map = new int[N][3];
        dp = new Integer[N][3];

        for(int i = 0; i < N; i++) {
            String[] costs = scanner.nextLine().split(" ");
            map[i][0] = Integer.parseInt(costs[0]);
            map[i][1] = Integer.parseInt(costs[1]);
            map[i][2] = Integer.parseInt(costs[2]);
        }

        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];


        for(int i = 1; i < N-1; i++) {
            dp[i][0] = Math.min(map[i+1][1], map[i+1][2]) + map[i][0];
            dp[i][1] = Math.min(map[i+1][0], map[i+1][2]) + map[i][1];
            dp[i][2] = Math.min(map[i+1][0], map[i+1][1]) + map[i][2];
        }

        System.out.println(Math.min(Math.min(dp[N-2][0], dp[N-2][1]), dp[N-2][2]));

    }


}
