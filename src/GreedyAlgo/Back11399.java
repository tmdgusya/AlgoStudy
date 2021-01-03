package GreedyAlgo;

import java.util.Arrays;
import java.util.Scanner;

public class Back11399 {
    static int n;
    static int[] dp;
    static int[] ATMWorkQueue;

    public static void main(String[] args) {
        int min = 0;
        int answer;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        ATMWorkQueue = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++){
            ATMWorkQueue[i] = scan.nextInt();
        }
        
        Arrays.sort(ATMWorkQueue);

        answer = getMinimumWorkingTime(dp);

        System.out.println(answer);
    }

    static int getMinimumWorkingTime(int[] dp){
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(i == 0) dp[0] = ATMWorkQueue[0];
            else dp[i] = dp[i-1] + ATMWorkQueue[i];
            sum += dp[i];
        }
        return sum;
    }
}
