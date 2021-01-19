package GreedyAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java11052 {
    static int[] card;
    static int[] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        card = new int[N+1];
        dp = new int[N+1];
        for(int i = 1; i <=N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        find();
        System.out.print(dp[N]);
    }

    static void find(){
        for(int i = 1; i <=N; i++){
            for(int j = 1; j <=i; j++){
                dp[i] = Math.max(dp[i-j] + card[j], dp[i]);
            }
        }
    }
}
