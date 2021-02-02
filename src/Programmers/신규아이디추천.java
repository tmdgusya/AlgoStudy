package Programmers;

import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 신규아이디추천 {

    public static void main(String[] args) {
        String test1 = "...!@BaT#*..y.abcdefghijklm";
        String test2 = "abcdefghijklmn.p";
        String test3 = "z-+.^.";
        String result = Solution.solution(test3);
        System.out.println(result);
    }
    static class Solution {
        public static String solution(String new_id) {
            String answer = new_id;
            answer = answer.toLowerCase(Locale.ROOT);
            answer = answer.replaceAll("[^0-9a-z._-]", "");
            answer = answer.replaceAll("[.]{2,}",".");
            if(answer.startsWith(".")){
                answer = answer.replaceFirst("[.]", "");
            }
            if(answer.endsWith(".")){
                int idx = answer.lastIndexOf(".");
                answer = answer.substring(0, idx);
            }
            if(answer.length() < 1){
                answer = "a";
            }
            if(answer.length() >= 16){
                answer = answer.substring(0, 15);
            }
            if(answer.endsWith(".")){
                int idx = answer.lastIndexOf(".");
                answer = answer.substring(0, idx);
            }
            while (answer.length() <= 2){
                String plusString = answer.substring(answer.length()-1, answer.length());
                answer += plusString;
            }
            return answer;
        }
    }
}

