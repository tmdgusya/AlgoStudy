package BackjunJudge;

import java.util.*;

class NTileling {
    // d[n] = d[n-2] + d[n-1]
    static int[] dp = new int[10];
    public static void main(String args[]){
        int n;
        int answer;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        answer = calculate(n);
        System.out.println(answer);
        scan.close();
    }
    
    static int calculate(int n){
        if(n == 1){ return 1;}
        if(n == 2){ return 2;}
        if(dp[n] != 0){ return dp[n]; }
        return dp[n] = calculate(n-2) + calculate(n-1);
    }

}