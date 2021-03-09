package Programmers.step3.섬연결하기;

import java.util.*;
import java.util.Map.Entry;

public class 섬연결하기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
    }

    static class Solution {

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

}
