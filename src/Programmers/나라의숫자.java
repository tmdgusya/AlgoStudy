package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 나라의숫자 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4));
    }

    static class Solution {
        public String solution(int n) {
            String answer = "";
            String[] numbers = {"4", "1", "2"};
            while(n > 0){
                int remainder = n % 3;
                n /= 3;

                if(remainder == 0) n--;

                answer = numbers[remainder] + answer;
            }
            return answer;
        }
    }
}
