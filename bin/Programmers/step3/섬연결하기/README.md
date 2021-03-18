- Greedy 를 이용하여 네트워크의 모든 정점을 최소 비용으로 연결하는 최적 해답을 구하는 것.
    - **Greedy ?**
        - 결정을 해야 할 때마다 **그 순간에 가장 좋다고 생각되는 것**을 선택함으로써 최종적인 선택에 도달 하는 것.
        - Greedy 방식의 풀이는 하나의 선택에서는 옳은 의사 결정일지는 몰라도, 전체적인 결과에서 안좋은 의사 결정일 수도 있다. 따라서 검증이 필요한 알고리즘이다.

## 동작

- 그래프의 간선들을 Cost 의 오름차순으로 정렬한다.
- 정렬된 간선 리스트에서 순서대로 **사이클을 형성하지 않는** 간선들을 선택한다.
    - 가장 낮은 가중치를 먼저 선택한다.
- 해당 간선을 현재의 MST(최소 비용 신장 트리)의 집합에 추가한다.
    - 여기서 간단히 느낀건 이걸 dfs 로 풀려한 내가 멍청했다. 크루스칼 알고리즘 방식으로 생각해보니 굳이 선들이 초반부터 연결될 이유가 없다. Cost 가 낮은 선들을 고르되, 그때 사이클을 형성하는지 안하는지만 판단해주면 되는것이였다.

## union-find Algorithm

- 간선의 양끝 정점이 같은 집합에 있는지 확인해야 한다.

```java
public class UnionFind {

    static int[] parents;

    public static void main(String[] args) {
        parents = new int[11];
        for(int i = 1; i <= 10; i++) {
            parents[i] = i;
        }
        connect();
        System.out.println(findParent(parents, 1, 2));
        System.out.println(findParent(parents, 1, 9));
    }

    /**
     * 그니까 결국에 부모 노드에 도착하면 부모 Node 랑 해당 가르키는 인덱스가 같을꺼임!
     */
    public static int getParent(int[] parent,  int x) {
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    /*
    부모를 합칠때는 일반적으로 더 작은 쪽의 값으로 합친다.
     */
    static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    /*
    부모가 같은지를 테스트 한다.
     */
    static boolean findParent(int[] parent, int a, int b) {
        return getParent(parent, a) == getParent(parent, b);
    }

    static void connect() {
        unionParent(parents, 1, 2);
        unionParent(parents, 3, 4);
        unionParent(parents, 5, 6);
        unionParent(parents, 7, 9);
    }
}
```

## 이를 이용한 섬연결하기의 문제풀이

## 문제

n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.

다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다. 예를 들어 A 섬과 B 섬 사이에 다리가 있고, B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.

**제한사항**

- 섬의 개수 n은 1 이상 100 이하입니다.
- costs의 길이는 `((n-1) * n) / 2`이하입니다.
- 임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호가 들어있고, costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
- 같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다. 즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
- 모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
- 연결할 수 없는 섬은 주어지지 않습니다.

**입출력 예**

|n|	costs|	return|
|---|:---:|:---:| 
|4	|[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]|	4|


## 풀이

```java
import java.util.*;

class Solution {

        static int[] parents;

        public int solution(int n, int[][] costs) {
            int answer = 0;
            parents = new int[n];

            Arrays.sort(costs, (o1, o2)->{return o1[2] - o2[2];});

            for(int i = 0; i < n; i++){
                parents[i] = i;
            }

            for(int[] info : costs) {
                int start = info[0];
                int end = info[1];
                int cost = info[2];
                if(findParent(parents, start, end)) continue;
                unionParent(parents, start, end);
                answer += cost;
            }
            
            return answer;
        }

        public int getParent(int[] parent, int x) {
            if(parent[x] == x) return x;
            return parent[x] = getParent(parent, parent[x]);
        }

        public void unionParent(int[] parent, int a, int b) {
            a = getParent(parent, a);
            b = getParent(parent, b);
            if(a < b) parent[b] = a;
            else parent[a] = b;
        }

        public boolean findParent(int[] parent, int a, int b) {
            return getParent(parent, a) == getParent(parent, b);
        }
    }
```
