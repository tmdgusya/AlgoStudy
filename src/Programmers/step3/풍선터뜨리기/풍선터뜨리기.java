package Programmers.step3.풍선터뜨리기;

import java.util.List;

public class 풍선터뜨리기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{9,-1,-5}));
    }

    static class Solution {
        public int solution(int[] a) {
            int answer = 0;
            int MAX_VALUE = 1000000000;

            int left = MAX_VALUE;
            int right = MAX_VALUE;

            for (int i = 0; i < a.length; i++) {
                if (a[i] < left) {
                    answer++;
                    left = a[i];
                }
                if (a[a.length - 1 - i] < right) {
                    answer++;
                    right = a[a.length - 1 - i];
                }
                if (left == right)
                    break;
            }

            return answer + (left == right ? -1 : 0);
        }
    }
}
