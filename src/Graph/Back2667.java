package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back2667 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0,0,1};
    static int[] dy = { 0,-1,1,0};
    static int size;
    static int count;
    static ArrayList<Integer> countOfHouse = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        visited = new boolean[size][size];

        for(int i = 0; i<size; i++){
            String[] input = br.readLine().split("");
            for(int j = 0; j<size; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i<size; i++){
            for(int j = 0; j <size; j++){
                if(map[i][j] == 1 && visited[i][j]){
                    count = 1;
                    bfs(i,j);
                    countOfHouse.add(count);
                }
            }
        }

        for(int i : countOfHouse){
            System.out.println(i);
        }
    }

    private static int bfs(int idx1, int idx2){
        visited[idx1][idx2] = true;

        for(int i = 0; i < dx.length; i++){
            int x = idx1 + dx[i];
            int y = idx2 + dx[i];
            if (x >= 0 && y >= 0 && x < size && y < size){
                if(!visited[x][y] && 0 != map[x][y]){
                    bfs(x,y);
                    count++;
                }
            }
        }
        return count;
    }
}
