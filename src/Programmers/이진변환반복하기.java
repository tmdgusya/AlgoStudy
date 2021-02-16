package Programmers;

import java.util.Arrays;

public class 이진변환반복하기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution("110010101001")));
    }

    static class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];
            int count = 0;
            int CountOfDeleteZero = 0;
            int currentlength = s.length();
            while (!s.equals("1")) {
                int deleteLength = s.replaceAll("0", "").length();
                count++;
                CountOfDeleteZero += currentlength - deleteLength;
                s = Integer.toBinaryString(deleteLength);
                currentlength = s.length();
            }
            answer[0] = count;
            answer[1] = CountOfDeleteZero;
            return answer;
        }
    }
}
