package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오컬러링북 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        final int[] solution1 = solution.solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
        System.out.println(Arrays.toString(solution1));
    }

    static class Solution {
        static boolean[][] visit;
        static int[] xMap = {-1,1,0,0};
        static int[] yMap = {0,0,1,-1};

        public int[] solution(int m, int n, int[][] picture) {
            int[] answer = new int[2];
            visit = new boolean[m][n];

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(visit[i][j] || picture[i][j] == 0){
                        continue;
                    }
                    answer[1] = Math.max(answer[1], bfs(picture, i, j));
                    answer[0]++;
                }
            }
            return answer;
        }

        int bfs(int[][] picture, int x, int y){
            Queue<int[]> queue = new LinkedList<>();
            int area = 1, dx, dy;
            visit[x][y] = true;
            queue.offer(new int[]{x,y});

            while (!queue.isEmpty()){
                int[] poll = queue.poll();

                for(int i = 0; i < 4; i++){
                    dx = poll[0] + xMap[i];
                    dy = poll[1] + yMap[i];

                    if(dx >= 0 && dy >= 0 && dx < picture.length && dy < picture[0].length){
                        if(!visit[dx][dy] && picture[dx][dy] != 0 && picture[poll[0]][poll[1]] == picture[dx][dy]){
                            visit[dx][dy] = true;
                            queue.offer(new int[]{dx, dy});
                            area++;
                        }
                    }
                }
            }
            return area;
        }
    }
}
