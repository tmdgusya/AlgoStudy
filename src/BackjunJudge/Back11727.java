package BackjunJudge;

import java.util.Scanner;

public class Back11727 {

    static Integer[] dp;
    static int n;
    //1 3 5 11 15
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        dp = new Integer[n+1];

        Integer answer = find(n);

        System.out.println(answer);
        scan.close();
    }
    public static Integer find(int x){
        if(x == 0) return 1;
        if(x == 1) return 3;
        if(x == 2) return 5;
        if(dp[x] != null) return dp[x];
        else dp[x] = 2*(find(x-2)) + find(x-1);
        return dp[x];
    }
}
