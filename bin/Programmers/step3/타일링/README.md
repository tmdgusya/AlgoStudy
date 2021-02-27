# [프로그래머스 Level3 - 2*N 타일링]

- Concept : Dynamic Programming -> fibonacci

- 잘게 쪼갠뒤 문제 풀기

- 이 문제가 왜 Level 3....?

```java
class Solution {

        static int[] dp;

        public int solution(int n) {
            int answer = 0;
            dp = new int[n+1];
            answer = sum(n);
            return answer;
        }

        public int sum(int n) {
            if(n == 0) {
                dp[0] = 1;
            }
            if(n == 1) {
                dp[1] = 1;
            }
            if(dp[n] != 0) {
                return dp[n];
            }
            dp[n] = (sum(n-1)  + sum(n-2)) % 1000000007;
            return dp[n] ;
        }
    }
```
