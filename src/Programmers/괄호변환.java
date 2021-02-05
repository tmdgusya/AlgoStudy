package Programmers;

import java.util.Arrays;

public class 괄호변환 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        final String solution1 = solution.solution("))((()");
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {

        StringBuilder sb = new StringBuilder();

        public String solution(String p) {
            if(p.equals("")) return "";
            return getValidateString(p);
        }

        public String getValidateString(String p){
            int index = splitString(p);
            String u = p.substring(0, index);
            System.out.println("u = " + u);
            String v = p.substring(index);

            if(validateString(u)) sb.append(u);
            else {
                sb.append("(");
                if(!v.equals("")){
                   getValidateString(v);
                }
                sb.append(")");
                sb.append(setValidateGrammer(u));
            }

            return sb.toString();
        }

        public int splitString(String p){
            String[] splitString = p.split("");
            int count = 0;
            int index = 0;
            for(int i = 0; i < splitString.length; i++){
                if(splitString[i].equals("(")) count++;
                else count--;

                if(count == 0){
                    index = i + 1;
                    break;
                }
            }
            return index;
        }

        public boolean validateString(String p){
            String[] split = p.split("");
            int count = 0;
            for(String s : split){
                if(s.equals("(")) count++;
                else count--;

                if(count < 0) return false;
            }
            return true;
        }

        public String setValidateGrammer(String p){
            String[] split = p.split("");
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i < split.length - 1; i++){
                if(split[i].equals("(")) sb.append(")");
                else sb.append("(");
            }
            return sb.toString();
        }
    }
}
