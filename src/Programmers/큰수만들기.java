package Programmers;

public class 큰수만들기 {

    public static void main(String[] args) {
        String number = "1231234";
        Solution solution = new Solution();
        System.out.println(solution.solution(number, 4));
    }

    static class Solution {
        public String solution(String number, int k) {
            StringBuilder answer = new StringBuilder();
            int idx = 0;
            int comp;
            for (int i = 0; i < number.length() - k; i++) {
                comp = 0;
                for (int j = idx; j <= i + k; j++) {
                    if (comp < number.charAt(j) - '0') {
                        comp = number.charAt(j) - '0';
                        idx = j + 1;
                    }
                }
                answer.append(comp);
            }
            return answer.toString();
        }
    }
}
