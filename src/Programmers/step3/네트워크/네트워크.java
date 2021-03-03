package Programmers.step3.네트워크;

public class 네트워크 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, new int[][]{{0,1,0} , {1,0,0} , {0,0,0}}));
    }

    static class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(computers, i, visited);
                    answer++;
                }
            }

            return answer;
        }

        boolean[] dfs(int[][] computers, int i, boolean[] visited) {
            visited[i] = true;
            for (int j = 0; j < computers.length; j++) {
                if (computers[i][j] == 1 && !visited[j]) {
                    visited = dfs(computers, j, visited);
                }
            }
            return visited;
        }
    }
}
