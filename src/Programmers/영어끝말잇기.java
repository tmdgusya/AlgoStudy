package Programmers;

import java.util.Arrays;

public class 영어끝말잇기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(3, new String[]{"tank", "kick",
                "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
    }

    static class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = new int[2];

            final int NUMBER_OF_FIRST_FAIL_PERSON = 0;
            final int NUMBER_OF_FIRST_FAIL_ROUND = 1;

            for(int i = 0; i < words.length; i++) {
                int z = i+1;
                if(isExist(words, i, words[i])){
                    answer[NUMBER_OF_FIRST_FAIL_PERSON] = (i%n)+1;
                    answer[NUMBER_OF_FIRST_FAIL_ROUND] = (i/n)+1;
                }
                if(i > 0 &&  !(words[i].charAt(0) == words[i-1].charAt(words[i-1].length()-1))){
                    answer[NUMBER_OF_FIRST_FAIL_PERSON] = (i%n)+1;
                    answer[NUMBER_OF_FIRST_FAIL_ROUND] = (i/n)+1;
                }
            }

            return answer;
        }

        public boolean isExist(String[] words, int point, String word) {
            for(int i = 0; i < point; i++){
                if(words[i].equals(word)){
                    return true;
                }
            }
            return false;
        }
    }
}
