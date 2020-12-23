package BackjunJudge;

import java.util.*;
import java.lang.Math;

class JumpStair {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int count_of_stair;
        int[] stairValue;
        int[] dp;
        count_of_stair = scan.nextInt();
        stairValue = new int[count_of_stair];
        dp = new int[count_of_stair+1];
        for(int i = 0; i<count_of_stair; i++){
            stairValue[i] = scan.nextInt();
        }
        dp[0] = stairValue[0];
        dp[1] = stairValue[1];
        for(int i = 3; i<=count_of_stair-2; i++){
            int x = dp[i-3] + dp[i-2] + stairValue[i];
            int y = dp[i-1] + dp[i-3] + stairValue[i];
            dp[i] = Math.max(x,y);
            System.out.println(dp[i]);
        }
        System.out.println(dp[count_of_stair-2]);
    }
    
}