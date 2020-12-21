package BackjunJudge;

import java.util.*;
import java.lang.Math;

public class MakeOne{
    
    public static void main(String args[]){
        int X;
        Scanner scan = new Scanner(System.in);
        X = scan.nextInt();
        int dp[] = new int[X+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= X; i++){
            dp[i] = dp[i-1] + 1;
            System.out.println(dp[i]);
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }
        System.out.println(dp[X]);
        scan.close();  
    }
}