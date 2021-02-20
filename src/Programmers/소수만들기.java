package Programmers;

public class 소수만들기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1,2,7,6,4}));
    }

    static class Solution {

        int answer = 0;

        public int solution(int[] nums) {
            nCr(nums, nums.length, 3, 0, 0);
            return answer;
        }

        public void nCr(int[] nums, int n, int r, int start, int result) {
            if(r == 0){
                if(isPrime(result)){
                    answer++;
                }
            }else{
                for(int i = start; i < nums.length; i++){
                    nCr(nums, n, r - 1, i + 1, result + nums[i]);
                }
            }
        }

        public static boolean isPrime(int num){
            for(int i=2; i*i<=num; i++){
                if(num % i == 0) return false;
            }
            return true;
        }
    }
}
