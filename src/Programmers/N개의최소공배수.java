package Programmers;

public class N개의최소공배수 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{2,6,8,14}));
    }

    static class Solution {
        public int solution(int[] arr) {
            int answer = 0;
            for(int i = 1; i < arr.length; i++){
                arr[i] = lcm(arr[i-1], arr[i]);
            }
            answer = arr[arr.length-1];
            return answer;
        }

        private int gcd(int a, int b){
            while(b!=0){
                int r = a%b;
                a = b;
                b = r;
            }
            return a;
        }

        private int lcm(int a, int b){
            return a*b / gcd(a,b);
        }
    }
}
