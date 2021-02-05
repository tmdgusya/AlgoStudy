package Programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 체육복 {

    public static void main(String[] args) {
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        int n = 5;
        int expectedData = 5;
        int result = Solution.solution(n, lost, reserve);
        System.out.println("Result = " + result + " ExpectedData = " + expectedData);
    }

    static class Solution {
        public static int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;
            int[] clothes = new int[n];
            for(int i = 0; i < n; i++){
                clothes[i] = 1;
            }
            for(int idx : lost){
                clothes[idx-1] -= 1;
            }
            for(int idx : reserve){
                clothes[idx-1] += 1;
            }
            for(int i = 0; i < n; i++){
                int frontIdx = i-1;
                int backIdx = i+1;
                if(clothes[i] == 2){
                    if(frontIdx >= 0){
                        if(clothes[frontIdx] == 0){
                            clothes[frontIdx] += 1;
                            clothes[i] -= 1;
                        }
                    }
                }
                if(clothes[i] == 2){
                    if(backIdx < n){
                        if(clothes[backIdx] == 0){
                            clothes[backIdx] += 1;
                            clothes[i] -= 1;
                        }
                    }
                }
            }
            for(int i : clothes){
                if(i > 0){
                    answer++;
                }
            }
            return answer;
        }
    }
}
