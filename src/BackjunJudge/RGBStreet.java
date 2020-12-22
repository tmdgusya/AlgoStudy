package BackjunJudge;

import java.util.*;
import java.lang.Math;

class RGBStreet {
    
    
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int n;
        int price;
        n = scan.nextInt();
        int[][] dp = new int[n+1][3];
        int[][] house = new int[n+1][3];
        for(int i = 1; i<=n; i++){
            for(int j = 0; j<n; j++){
                price= scan.nextInt();
                house[i][j] = price;
            }
        }

        for(int i = 1; i <= n; i++){
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2];
        }
        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
}