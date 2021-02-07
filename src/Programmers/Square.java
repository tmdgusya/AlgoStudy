package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Square {

    public static void main(String[] args) {
        int[][] v = {{1,4}, {3,4}, {3,10}};
        Solution solution = new Solution();
        int[] solution1 = solution.solution(v);
        System.out.println(Arrays.toString(solution1));
    }

    static class Solution {
        public int[] solution(int[][] v) {
            int[] answer = {};
            Map<Integer, Integer> numbers = new HashMap<>();

            for(int[] i : v){
                for(int num : i){
                    if(numbers.containsKey(num)){
                        Integer value = numbers.get(num);
                        value++;
                        numbers.put(num, value);
                    }else{
                        numbers.put(num, 1);
                    }
                }
            }
            // 다 꺼내서 1인거만 호ㅓㅏㄱ인
            for(int[] i : v) {
                for (int num : i) {

                }
            }

            System.out.println(numbers.toString());

            return answer;
        }
    }
}
