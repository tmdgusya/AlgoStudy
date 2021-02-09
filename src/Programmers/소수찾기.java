package Programmers;

public class 소수찾기 {

    public static void main(String[] args) {

    }

    static class Solution {
        public int solution(String numbers) {
            int answer = 0;

            return answer;
        }
    }


    public static boolean isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }



}
