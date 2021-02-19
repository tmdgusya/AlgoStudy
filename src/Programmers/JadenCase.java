package Programmers;

import java.util.Arrays;

public class JadenCase {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("3people unFollowed me"));
    }

    static class Solution {
        public String solution(String s) {
            StringBuilder answer = new StringBuilder();

            char firstChar = s.charAt(0);
            answer.append(Character.toUpperCase(firstChar));

            for (int i = 1; i < s.length(); i++) {
                char now = s.charAt(i);
                if (s.charAt(i - 1) == ' ') {
                    answer.append(Character.toUpperCase(now));
                } else {
                    answer.append(Character.toLowerCase(now));
                }
            }

            return answer.toString();
        }
    }
}
