package BackjunJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1904 {

    static int size;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        dp = new Integer[size+1];
        dp[0] = 0;
        dp[1] = 1;
        if(size > 1){
            dp[2] = 2;
        }
        search(size);
        System.out.println(dp[size]);
    }

    static private int search(int n){
        if(dp[n] != null) return dp[n];
        return dp[n] = (search(n-1) + search(n-2)) % 15746;
    }
}
