package Programmers.step3.정수삼각형;

public class 정수삼각형 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    static class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            for(int i = triangle.length-1; i >= 1; i--) {
                for(int j = 1; j < triangle[i].length; j++) {
                    triangle[i-1][j-1] =
                            Math.max(triangle[i][j] + triangle[i-1][j-1], triangle[i][j-1] + triangle[i-1][j-1]);
                }
            }
            answer = triangle[0][0];
            return answer;
        }
    }

}
