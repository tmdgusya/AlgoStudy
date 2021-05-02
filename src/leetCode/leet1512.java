package leetCode;

public class leet1512 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numIdenticalPairs(new int[]{1,2,3,1,1,3}));
    }

    static class Solution {
        public int numIdenticalPairs(int[] nums) {

            int count = 0;

            for(int i = 0; i < nums.length; i++) {
                for(int j = i+1; j < nums.length; j++) {
                    if(nums[i] == nums[j]) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
