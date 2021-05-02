package leetCode;

import java.util.*;

public class leet1431 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kidsWithCandies(new int[]{2,3,5,1,3}, 3));
    }

    static class Solution {

        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

            List<Boolean> list = new ArrayList<>();

            int maxCount = 0;

            for(int candy : candies) {
                maxCount = Math.max(maxCount, candy);
            }

            for(int candy : candies) {
                if(candy+extraCandies >= maxCount) {
                    list.add(true);
                }else {
                    list.add(false);
                }
            }

            return list;

        }
    }
}
