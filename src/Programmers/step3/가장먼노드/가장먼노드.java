package Programmers.step3.가장먼노드;


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
