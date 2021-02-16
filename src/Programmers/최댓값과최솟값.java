package Programmers;

public class 최댓값과최솟값 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String case1 = "1 2 3 4";
        String case2 = "-1 -2 -3 -4";
        System.out.println(solution.solution(case2));
    }

    static class Solution {
        public String solution(String s) {
            String[] numbers = s.split(" ");
            int min = 0;
            int max = 0;
            max = min = Integer.parseInt(numbers[0]);
            for(String a : numbers){
                int ele = Integer.parseInt(a);
                if(min > ele){
                    min = ele;
                }
                if(max < ele){
                    max = ele;
                }
            }
            String answer = min + " " + max;
            return answer;
        }
    }
}
