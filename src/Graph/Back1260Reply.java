package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back1260Reply {

    static ArrayList<Integer>[] list;
    static int vertax;
    static int line;
    static int startPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        vertax = Integer.parseInt(str.nextToken());
        line = Integer.parseInt(str.nextToken());
        startPoint = Integer.parseInt(str.nextToken());
        list = new ArrayList[line];

        for(int i = 0; i < line; i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i<line; i++){
            StringTokenizer loop = new StringTokenizer(br.readLine(), " ");
            int node = Integer.parseInt(loop.nextToken());
            int nextNode = Integer.parseInt(loop.nextToken());

            list[node].add(nextNode);
        }

        for (ArrayList<Integer> dodo : list) {
            System.out.println(dodo.toString());
        }
    }

    static public void dfs(){

    }

    static public void bfs(){

    }
}
