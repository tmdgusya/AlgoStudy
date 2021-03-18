# 프로그래머스 가장 먼 노드 level3 

## 문제 

n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다. 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.

노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.

제한사항
노드의 개수 n은 2 이상 20,000 이하입니다.
간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.
입출력 예

| n | vertex | return |
|---|:---:|:---:|
| 6 | [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]] | 3 |

## 풀이 Concept

- 노드와 노드의 연결관계를 ArrayList 중첩으로 표현

- 길이는 preNode 기준으로 +1 씩

## 풀이

```java
import java.util.*;

public class 가장먼노드 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }


    static class Solution {

        static ArrayList<ArrayList<Integer>> list;
        static int[] distances;
        static boolean[] visited;

        public int solution(int n, int[][] edges) {

            list = new ArrayList<>();
            distances = new int[n+1];
            visited = new boolean[n+1];

            for(int i = 0; i < n+1; i++) {
                list.add(new ArrayList<Integer>());
            }

            for(int[] edge : edges) {
                list.get(edge[0]).add(edge[1]);
                list.get(edge[1]).add(edge[0]);
            }

            dfs();

            return findMaxLengthNode();
        }

        public void dfs() {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            visited[0] = visited[1] = true;
            while(!queue.isEmpty()) {
                int nodeIdx = queue.poll();
                for(int node : list.get(nodeIdx)) {
                    if(!visited[node]) {
                        distances[node] = distances[nodeIdx] + 1;
                        visited[node] = true;
                        queue.offer(node);
                    }
                }
            }
        }

        public int findMaxLengthNode() {
            int maxLength = 0;
            int answer = 0;
            for(int i : distances) {
                maxLength = Math.max(maxLength, i);
            }
            for(int i : distances) {
                if(maxLength == i)
                    answer++;
            }
            return answer;
        }

    }
}

```
