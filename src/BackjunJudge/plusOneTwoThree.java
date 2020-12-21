package BackjunJudge;

import java.util.*;

class plusOneTwoThree{
    
    public static void main(String args[]){
        int T; // Case count
        int n; // numer
       
        Scanner scan = new Scanner(System.in);
        T = scan.nextInt();
        for(int i = 0; i< T; i++){
            n = scan.nextInt();
            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int j = 4; j<=n; j++){
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            System.out.println(dp[n]);
        }
    }
}