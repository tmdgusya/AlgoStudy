# 프로그래머스 level3 디스크 컨트롤러

## Concept

SJF 스케쥴링 방법을 이용하면 된다.

- 준비 큐에서 가장 짧은 프로세스에게 CPU 할당

- 반환시간 : 실행 완료 시간
- 대기시간 : 시작시간 - 도착시간

우리 문제로 치면

- 작업시간(job[1])이 짧은 것들로 작업큐를 sorting 한다.

- 대기큐는 작업요청시점 순으로 sorting 한다.

## 로직

- 지금 시간 이하의 요청 작업을 대기 큐에서 전부 작업으로 로딩한다.

- Working Queue 에서 작업시간이 가장 짧은걸 로딩한다.

- 현재시간에 작업시간을 더해준다.

- 작업을 할경우 cnt 를 ++ 해준다.

- 작업큐가 비어있을 경우 현재시간을 +1 한다.

- 작업횟수가 jobs.length 랑 같다면 종료한다

## 풀이

```java
public class 디스크컨트롤러 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        final int solution1 = solution.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
        System.out.println(solution1);
    }

    static class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;
            int cnt = 0;
            LinkedList<int[]> waiting = new LinkedList<>();
            PriorityQueue<int[]> workQueue
                    = new PriorityQueue<>(new Comparator<int[]> (){
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });

            for(int[] job : jobs) {
                waiting.offer(job);
            }
            Collections.sort(waiting, (o1, o2) -> {
                return o1[0] - o2[0];
            });

            int time = waiting.peek()[0];

            while(cnt < jobs.length) {
                while(!waiting.isEmpty() && waiting.peek()[0] <= time) {
                    workQueue.offer(waiting.pollFirst());
                }
                if(!workQueue.isEmpty()) {
                    int[] j = workQueue.poll();
                    time += j[1];
                    answer += time - j[0];
                    cnt++;
                } else {
                    time++;
                }
            }

            return answer / jobs.length;
        }
    }
}

```
