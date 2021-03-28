package BackjunJudge;

import java.util.Scanner;

public class Back13305 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        long[] dist = new long[N - 1];
        long[] cost = new long[N];

        for(int i = 0; i < N - 1; i++) {
            dist[i] = in.nextLong();
        }

        for(int i = 0; i < N; i++) {
            cost[i] = in.nextLong();
        }

        long sum = 0;
        long minCost = cost[0];

        for(int i = 0; i < N - 1; i++) {

            if(cost[i] < minCost) {
                minCost = cost[i];
            }

            sum += (minCost * dist[i]);
        }

        System.out.println(sum);

    }
}
