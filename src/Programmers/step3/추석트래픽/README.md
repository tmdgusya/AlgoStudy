# Concept

lines 배열은 1 ~ 2000 개의 로그 문자열 [요청에 대한 응답완료 시간 S / 처리시간 T]

- responseTime (S) : 2016-09-15 hh:mm:ss.sss 로 구성되어 있다
- processingTime (T) : 0.1s , 0.312s, 2s 와 같이 최대 소수점 셋째 자리까지 기록하며 뒤에는 초단위를 의미하는 s 로 끝난다.
- 2016-09-15 03:10:33.020 0.011s 은 33.020 부터 0.011s 동안 처리된 요청을 의미한다.

제일 많이 겹치는 시간대의 구간 개수를 return

Concept : 각 시간별로 동일한 초체계로 바꾼다음 더해준다.

H : * 60 * 60 * 1000
M : * 60 * 1000
S : * 1000

END_TIME = H+M+S

STRAT_TIME = END_TIME - PROCESSING_TIME

서버에는 타임아웃이 3초로 적용되어 있기 때문에 처리시간은 0.001 ≦ T ≦ 3.000이다.

이니까 1Mill 를 더해줘야하는구나.. 이것때문에 계속안풀렸네 ..

STRAT_TIME = END_TIME - PROCESSING_TIME + 1

## 풀이간 일어났던 고행

`0.001 ≦ T ≦ 3.000이다.` 해당 부분을 잘 인지하지 못해서 `0.000 ≦ T ≦ 3.000이다.` 에서 3으로 인지하고 있었다.

## 여기서 배워가는 점

시간 개념이 나오면 뭔가 계산할 수 있는 것들로 Convert 하는 것이 좋다.

라이브러리를 안다면 더욱 좋겠지만 모른다면 빠르게 자신이 변환해낼 수 있는 체계로서 변환해 내는것이 좋다.

## Code

```java
class Solution {

        public static int SECOND = 1000;
        public static int MINUTE_TO_SECOND = 60;

        public int solution(String[] lines) {
            int answer = 0;
            int[] startTimes = new int[lines.length];
            int[] endTimes = new int[lines.length];
            convertToSecond(lines, startTimes, endTimes);

            answer = getAnswer(lines, answer, startTimes, endTimes);

            return answer;
        }

        private int getAnswer(String[] lines, int answer, int[] startTimes, int[] endTimes) {
            for(int i = 0; i < lines.length ; i++) {
                int task = 0;
                int startTime = endTimes[i];
                int endTime = startTime + 1000;

                for(int j = 0; j < lines.length ; j++) {
                    if(startTimes[j] >= startTime && startTimes[j] < endTime) {
                        task++;
                    } else if(endTimes[j] >= startTime && endTimes[j] < endTime) {
                        task++;
                    } else if(startTimes[j] <= startTime && endTimes[j] >= endTime) {
                        task++;
                    }
                }

                answer = Math.max(task, answer);
            }
            return answer;
        }

        private void convertToSecond(String[] lines, int[] startTimes, int[] endTimes) {
            for(int i = 0 ; i < lines.length ; i++) {
                String[] log = lines[i].split(" ");
                String[] responseTime = log[1].split(":");
                int processingTime = (int) (Double.valueOf(log[2].substring(0, log[2].length() - 1)) * SECOND);
                int startTime = 0;
                int endTime = 0;

                endTime += Integer.parseInt(responseTime[0]) * MINUTE_TO_SECOND * MINUTE_TO_SECOND * SECOND;
                endTime += Integer.parseInt(responseTime[1]) * MINUTE_TO_SECOND * SECOND;
                endTime += (int)(Double.parseDouble(responseTime[2]) * SECOND);
                startTime = endTime - processingTime + 1;

                startTimes[i] = startTime;
                endTimes[i] = endTime;
            }
        }
    }
```
