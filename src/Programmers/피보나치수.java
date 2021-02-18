package Programmers;

public class 피보나치수 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(44));
    }

    static class Solution {

        static Integer[] dp;

        public int solution(int n) {
            int answer = 0;
            dp = new Integer[n+1];
            answer = fibonacci(n);
            return (answer % 1234567);
        }

        public int fibonacci(int n){
            if(n == 0)
                return 0;
            if(n == 1)
                return 1;
            if(dp[n] != null){
                return dp[n] % 1234567;
            }
            return dp[n] = fibonacci(n-2)% 1234567 + fibonacci(n-1)% 1234567;
        }
    }
}
