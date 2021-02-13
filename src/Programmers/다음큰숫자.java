package Programmers;

public class 다음큰숫자 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(78));
    }

    static class Solution {
        public int solution(int n) {
            int answer = n;
            while(true){
                answer = answer + 1;
                if(findCountOfOne(getBinary(n)) == findCountOfOne(getBinary(answer))){
                    break;
                }
            }
            return answer;
        }

        private int findCountOfOne(String binary){
            int count = 0;
            for(int i = 0; i < binary.length(); i++){
                if(binary.charAt(i) == '1'){
                    count++;
                }
            }
            return count;
        }

        private String getBinary(int n){
//            StringBuilder sb = new StringBuilder();
//            while(n != 0){
//                sb.append(n%2);
//                n = n/2;
//            }
//            return sb.reverse().toSring();
            return Integer.toBinaryString(n);
        }
    }


}
