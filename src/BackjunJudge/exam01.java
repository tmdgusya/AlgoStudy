package BackjunJudge;

import java.lang.reflect.Array;
import java.util.Arrays;

public class exam01 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(670));
    }

    static class Solution{

        public int solution(int N){
            String s = String.valueOf(N);
            int inputIndex = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(0) == '-'){
                    ++i;
                    if(Integer.parseInt(String.valueOf(s.charAt(i))) > 5){
                        inputIndex = i;
                        break;
                    }
                }else{
                    if(Integer.parseInt(String.valueOf(s.charAt(i))) < 5){
                        inputIndex = i;
                        break;
                    }
                }
            }
            System.out.println(inputIndex);
            char[] insert5Digit = new char[s.length()+1];
            for(int i = 0; i < s.length(); i++){
                if(i >= inputIndex){
                    insert5Digit[i+1] = s.charAt(i);
                }else {
                    insert5Digit[i] = s.charAt(i);
                }

            }
            insert5Digit[inputIndex] = '5';
            int n = Integer.parseInt(new String(insert5Digit));
            return n;
        }
    }

}
