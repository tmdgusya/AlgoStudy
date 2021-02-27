package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 폰켓몬 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{3,1,2,3}));
    }

    static class Solution {
        public int solution(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int a : nums){
                set.add(a);
            }
            if(set.size() < nums.length/2) {
                return set.size();
            }else
                return nums.length/2;
        }
    }
}
