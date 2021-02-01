package Programmers;
import java.util.*;

public class 두개뽑아서더하기 {

    public static void main(String[] args) {
        int[] case1 = {2,1,3,4,1};
        int[] expectedData = {2,3,4,5,6,7};
        int[] solution = Solution.solution(case1);
        System.out.println(Arrays.toString(solution));
    }

    static class Solution {
        public static int[] solution(int[] numbers) {
            int idx = 0;
            HashSet<Integer> array = new HashSet<Integer>();
            for(int i = 0; i < numbers.length; i++){
                for(int j = 0; j < numbers.length; j++){
                    if(i != j){
                        array.add(numbers[i] + numbers[j]);
                    }
                }
            }
            ArrayList<Integer> arraylist = new ArrayList<>(array);
            Collections.sort(arraylist);
            int[] answer = new int[arraylist.size()];
            for(int a : arraylist){
                answer[idx++] = a;
            }
            return answer;
        }
    }
}
