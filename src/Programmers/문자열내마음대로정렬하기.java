package Programmers;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"sun", "bed", "car"}, 1)));
    }

    static class Solution {
        public String[] solution(String[] strings, int n) {
            ArrayList<CustomComparator> customArchi = new ArrayList<>();
            Arrays.sort(strings);
            for(String s : strings){
                customArchi.add(new CustomComparator(s, n));
            }
            Collections.sort(customArchi);
            String[] answer = new String[customArchi.size()];
            int i = 0;
            for(CustomComparator c : customArchi){
                answer[i] = c.word;
                i++;
            }
            return answer;
        }
    }

    static class CustomComparator implements Comparable<CustomComparator> {

        String word;
        int n;

        public CustomComparator(String word, int n) {
            this.word = word;
            this.n = n;
        }

        @Override
        public int compareTo(CustomComparator o) {
            return Character.compare(word.charAt(n), o.word.charAt(n));
        }

    }
}
