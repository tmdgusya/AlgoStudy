package Programmers;

import java.util.*;

public class Retry {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}};
        solution.solution(6,4, picture);
    }

    static class Solution {

        static boolean[][] visit;
        static int[] xD = {-1,1,0,0};
        static int[] yD = {0,0,-1,1};

        public int[] solution(int m, int n, int[][] picture) {
            visit = new boolean[m][n];
            int[] answer = new int[2];
            int area = 0;
            for(int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if(visit[i][j] ||picture[i][j] == 0){
                        continue;
                    }
                    answer[1] = Math.max(answer[1], bfs(picture, i, j));
                    area++;
                }
            }
            answer[0] = area;
            System.out.println(Arrays.toString(answer));
            return answer;
        }

        public static int bfs(int[][] picture, int x, int y){
            Queue<int[]> queue = new LinkedList();
            int count = 1;
            queue.add(new int[]{x, y});
            while(!queue.isEmpty()){
                final int[] poll = queue.poll();
                visit[poll[0]][poll[1]] = true;
                for(int i = 0; i < 4; i++){
                    int dx = xD[i] + poll[0];
                    int dy = yD[i] + poll[1];
                    if(dx >= 0 && dx < picture.length && dy >= 0 && dy < picture[0].length){
                        if(!visit[dx][dy] && picture[dx][dy] != 0 && picture[poll[0]][poll[1]] == picture[dx][dy]){
                            visit[dx][dy] = true;
                            count++;
                            queue.offer(new int[]{dx, dy});
                        }
                    }
                }
            }
            return count;
        }
    }
}
