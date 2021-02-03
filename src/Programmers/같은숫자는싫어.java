package Programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 같은숫자는싫어 {


    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        int[] solution = Solution.solution(arr);
    }

    static class Solution {
        public static int[] solution(int []arr){
            ArrayList<Integer> arrayList = new ArrayList<>();
            int lastnumber = arr[0];
            arrayList.add(arr[0]);
            for (int ele : arr){
                if(ele != lastnumber){
                    arrayList.add(ele);
                }
                lastnumber = ele;
            }
            int[] answer = new int[arrayList.size()];
            for(int i = 0; i < arrayList.size(); i++){
                answer[i] = arrayList.get(i);
            }
            return answer;
        }
    }
}


