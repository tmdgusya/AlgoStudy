package Graph.Description;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back2667 {
    static int[][] map;
    static boolean[][] visited;
    static int[] aparts;
    static int[] dx = {-1, 0,0,1};
    static int[] dy = { 0,-1,1,0};
    static int size;
    static ArrayList<Integer> HouseComplex = new ArrayList<>();
    static int apartNum = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        aparts = new int[size*size];
        visited = new boolean[size][size];
        addMap(br);
        for(int i = 0; i < size; i++){
            for(int j = 0; j <size; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    apartNum++;
                    bfs(i,j);
                }
            }
        }
        Arrays.sort(aparts);
        System.out.println(apartNum);

        for(int i=0; i<aparts.length; i++){
            if(aparts[i] == 0){
            }else{
                System.out.println(aparts[i]);
            }
        }
    }

    private static void addMap(BufferedReader br) throws IOException {
        for(int i = 0; i<size; i++){
            String input = br.readLine();
            String[] split = input.split("");
            for(int j = 0; j <size; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
    }

    private static void dfs(int x, int y){
        visited[x][y] = true;
        aparts[apartNum]++;
        for (int i = 0; i < 4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx >= 0 && ny >= 0 && nx < size && ny < size){
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    count++;
                    dfs(nx,ny);
                }
            }
        }
    }

    private static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        aparts[apartNum]++;

        while (!queue.isEmpty()){
            int curX = queue.peek()[0];
            int curY = queue.peek()[1];
            queue.poll();

            for(int i = 0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if(nx >= 0 && ny >= 0 && nx < size && ny < size){
                    if(map[nx][ny] == 1 && !visited[nx][ny]){
                        aparts[apartNum]++;
                        queue.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }

            }
        }
    }
}
