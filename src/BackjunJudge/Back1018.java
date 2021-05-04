package BackjunJudge;

import java.io.*;
import java.util.*;

public class Back1018 {

    static int[] xDir = {1, 0};
    static int[] yDir = {0, 1};
    static boolean[][] visited;
    static char[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String[] columns = br.readLine().split("");
            for(int j = 0; j < columns.length; j++) {
                map[i][j] = columns[j].charAt(0);
            }
        }

        validate();

        bfs(0,0);

        System.out.println(answer);

    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();

            for(int i = 0; i < 2; i++) {
                int dx = poll[0] + xDir[i];
                int dy = poll[1] + yDir[i];
                if(dx >= 0 && dx < map.length && dy >= 0 && dy < map[0].length && !visited[dx][dy]) {
                    char a = map[poll[0]][poll[1]];
                    if(a == map[dx][dy]) {
                        if(a == 'W') {
                            map[dx][dy] = 'B';
                        }else{
                            map[dx][dy] = 'W';
                        }
                        answer++;
                    }
                    visited[dx][dy] = true;
                    queue.offer(new int[]{dx, dy});
                }
            }
        }
    }

    public static void validate(){
        if(map[0][0] == 'W') {
            if(map[0][1] != 'B'){
                answer++;
            }
            map[0][1] = 'B';
            if(map[1][0] != 'B'){
                answer++;
            }
            map[1][0] = 'B';
        }

        if(map[0][0] == 'B') {
            if(map[0][1] != 'W'){
                answer++;
                map[0][1] = 'W';
            }

            if(map[1][0] != 'W') {
                answer++;
                map[1][0] = 'W';
            }
        }
    }
}
