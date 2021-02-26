package Programmers.step3.타일링;

public class N타일링 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5));
    }

    static class Solution {

        static int[] dp;

        public int solution(int n) {
            int answer = 0;
            dp = new int[n+1];
            answer = sum(n);
            return answer;
        }

        public int sum(int n) {
            if(n == 0) {
                dp[0] = 1;
            }
            if(n == 1) {
                dp[1] = 1;
            }
            if(dp[n] != 0) {
                return dp[n];
            }
            dp[n] = (sum(n-1)  + sum(n-2)) % 1000000007;
            return dp[n] ;
        }
    }
}
