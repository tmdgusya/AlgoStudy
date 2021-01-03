package BackjunJudge;

import java.util.Scanner;

public class Back9461 {
    static long[] dp;
    static int n;

    public static void main(String[] args) {

        int key;
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        dp = new long[101];

        //n 번 수행
        for(int i = 0; i < n; i++){
            key = scan.nextInt();
            System.out.println(getSideLength(key-1));
        }
        scan.close();
    }

    public static long getSideLength(int key){
        if(key == 0) return 1;
        if(key == 1) return 1;
        if(key == 2) return 1;
        if(dp[key] != 0) return dp[key];
        else dp[key] = getSideLength(key - 3) + getSideLength(key - 2);
        return dp[key];
    }
}
