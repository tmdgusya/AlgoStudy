package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back2178 {
    static int[][] miro;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int x;
    static int y;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        miro = new int[x][y];
        visited = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            String s = br.readLine();
            for (int j = 0; j < y; j++) {
                String[] split = s.split("");
                miro[i][j] = Integer.parseInt(split[j]);
            }
        }

        bfs(0, 0);

        System.out.println(miro[x - 1][y - 1]);
    }

    public static void bfs(int index, int index2) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{index, index2});

        while (!q.isEmpty()) {
            int location[] = q.poll();
            visited[index][index2] = true;
            for (int dir = 0; dir < 4; dir++) {
                int r = location[0] + dx[dir];
                int c = location[1] + dy[dir];
                if (r >= 0 && c >= 0 && r < x && c < y) {
                    if (miro[r][c] != 0 && !visited[r][c]) {
                        q.offer(new int[]{r, c});
                        visited[r][c] = true;
                        miro[r][c] = miro[location[0]][location[1]] + 1;

                    }
                }
            }
        }
    }
}


