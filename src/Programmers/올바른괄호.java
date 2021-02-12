package Programmers;

public class 올바른괄호 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(")()("));
    }

    static class Solution {
        boolean solution(String s) {
            int count = 0;
            boolean answer = true;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == ')')
                    count--;
                if(s.charAt(i) == '(')
                    count++;
                if(count < 0){
                    answer = false;
                    break;
                }
            }
            if(count != 0){
                answer = false;
            }
            return answer;
        }
    }
}
