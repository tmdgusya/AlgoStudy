# 프로그래머스 여행 경로

[문제링크](https://programmers.co.kr/learn/courses/30/lessons/43164?language=java)

개인적으로 예전에 순열 직접 구현할때 이런식으로 구현했어서 바로 이렇게 해볼까? 했던 문제 ㅋㅋ

효율성이 나갈줄 알았는데 왠일인지 높은 점수를 받았다!

나랑 다 비슷하게 푼것같다

## Concept

- 배열을 돌면서 ICN 부터 시작한다.

- [i][1] 번째가 도착지이다. 해당 부분을 찾아서 계속 재귀를 돌린다.

- 재귀할때 순열 조합 구현때 이용했던 문자열을 더해서 전해주는걸 한다. (나중에 띄어쓰기로 나눌꺼임)

- list 를 알파벳 순으로 정렬한다. (요구사항)

- list.get(0) 에 있는 경로 문자열이 정답이다.

- 해당 문자열을 split 한다~!

## 풀이

```java
import java.util.*;

public class 여행경로 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[][]{
                {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
    }

    static class Solution {

        static ArrayList<String> paths;
        static boolean[] visited;

        public String[] solution(String[][] tickets) {
            paths = new ArrayList<String>();
            visited = new boolean[tickets.length];
            dfs(tickets, "ICN", "ICN", 0);
            Collections.sort(paths);
            String[] answer = paths.get(0).split(" ");
            return answer;
        }

        public void dfs(String[][] tickets, String start, String path, int count) {
            if(count == tickets.length) {
                paths.add(path);
                return;
            }
            for(int i = 0; i < tickets.length; i++) {
                if(!visited[i] && tickets[i][0].equals(start)) {
                    visited[i] = true;
                    dfs(tickets, tickets[i][1], path + " " + tickets[i][1], count+1);
                    visited[i] = false;
                }
            }
        }
    }
}

```
