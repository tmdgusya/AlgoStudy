package Programmers;

public class 괄호변환 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        final String solution1 = solution.solution("()))((()");
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {

        StringBuilder sb = new StringBuilder();

        public String solution(String p) {
            if(p.equals("")) return "";
            return makeString(p);
        }

        public String makeString(String p){

            int index = splitString(p);
            String u = p.substring(0, index);
            String v = p.substring(index);

            if(checkString(u)) sb.append(u);
            else {
                sb.append("(");
                if(!v.equals("")){
                   makeString(v);
                }
                sb.append(")");
                sb.append(reverseString(u));
            }
            if(!v.equals("")) makeString(v);

            return sb.toString();
        }

        public int splitString(String p){
            // 그니까 이 함수가 문자열을 균형잡이 u 와 나머지 부분인 v 로 나누는 작업을 한다.
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

        public boolean checkString(String p){
            String[] split = p.split("");
            int count = 0;
            for(String s : split){
                if(s.equals("(")) count++;
                else count--;

                if(count < 0) return false;
            }
            return true;
        }

        public String reverseString(String p){
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
