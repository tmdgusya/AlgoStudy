package leetCode;

import java.util.Arrays;
import java.util.Collections;

public class TwoSum {

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i]+nums[j] == target){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;
    }
}
