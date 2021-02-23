package Programmers;

public class 점프와순간이동 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5));
    }

    static public class Solution {
        public int solution(int n) {
            int ans = 0;
            final String s = Integer.toBinaryString(n);
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '1'){
                    ans++;
                }
            }
            return ans;
        }
    }
}
