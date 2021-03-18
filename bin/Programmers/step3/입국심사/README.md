## 컨셉

1. 특정 시간이 주어졌을때 Inspector 들이 몇명을 검사하는지 계산

만약 n 시간대 보다 크다면 시간대를 줄이고, n 보다 작다면 시간대를 늘린다.

## 풀이

```java
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long minTime = 1;
        long maxTime = (long)times[times.length-1]*n;
        long middleTime = 0;
        long sum;
        long answer = maxTime;

        while(minTime <= maxTime) {
            sum = 0;
            middleTime = (minTime + maxTime) / 2;
            for(int time : times) {
                sum += middleTime/time;
            }
            if(sum >= n) {
                if(middleTime < answer) {
                    answer = middleTime;
                }
                maxTime = middleTime-1;
            }else {
                minTime = middleTime+1;
            }
        }
        return answer;
    }
}
```
