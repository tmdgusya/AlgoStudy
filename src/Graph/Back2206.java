package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back2206 {

    static int x;
    static int y;
    static int map[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean visit[][];
    static boolean isbreaking[][];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] point = br.readLine().split(" ");
        x = Integer.parseInt(point[0]);
        y = Integer.parseInt(point[1]);
        visit = isbreaking = new boolean[x][y];
        map = new int[x][y];

        for (int i = 0; i < x; i++){
            int j = 0;
            String[] split = br.readLine().split("");
            for (String ele : split){
                map[i][j] =  Integer.parseInt(ele);
                j++;
            }

        }

        dfs(0,0);
        System.out.println(count);
    }

    public static void dfs(int x_, int y_){
        System.out.println(x_ + " " + y_);
        visit[x_][y_] = true;

        if(x == (x_-1) && y == (y_ -1)){
            System.out.println(count);
            return;
        }
        for (int i = 0; i<4; i++){
            int nx = x_ + dx[i];
            int ny = y_ + dy[i];
            if(nx >= 0 && ny >= 0 && nx < x && ny < y){
                System.out.println(map[x_][y_]+ " 좌표 : " + nx + " " + ny);
                if(!visit[nx][ny] && map[nx][ny] == 0){
                    count++;
                    visit[nx][ny] = true;
                    dfs(nx, ny);
                }else if(!visit[nx][ny] && map[nx][ny] == 1 && !isbreaking[nx][ny]){
                    count++;
                    isbreaking[nx][ny] = true; // true 면 뿌순거 false 면 뿌술수있는거
                    dfs(nx, ny);
                }
            }
        }
    }
}
