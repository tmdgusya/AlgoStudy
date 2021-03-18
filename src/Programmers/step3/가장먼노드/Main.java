package Programmers.step3.가장먼노드;

import java.util.*;
import java.io.*;

public class Main {
    static Integer[] dp;
    static int zero;
    static int one;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        dp = new Integer[num+1];

        for(int i = 0; i < num; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new Integer[num+1];
            zero = 0;
            one = 0;
            fibonacci(n);
            System.out.print(zero+ " " +one);
        }
    }

    public static int fibonacci(int n) {
        if(n == 0) {
            zero++;
            return 0;
        }
        if(n == 1) {
            one++;
            return 1;
        }
        if(dp[n] != null) {
            return dp[n];
        }
        return dp[n] = fibonacci(n-1) + fibonacci(n-2);
    }

}
