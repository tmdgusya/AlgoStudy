package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS {
    static ArrayList<Integer>[] lists;
    static int n;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int linecount = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        lists = new ArrayList[n+1];

        for(int i = 1; i < n+1; i++){
            lists[i] = new ArrayList<>();
        }
        //연결관계 구성
        for(int i = 0; i < linecount; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            lists[u].add(v);
            lists[v].add(u);
        }
        for(int i = 1; i < n + 1; i++){
            Collections.sort(lists[i]);
        }

        check = new boolean[n+1];
        dfs(start);
        System.out.println();

        check = new boolean[n+1];
        bfs(start);
    }

    private static void dfs(int x) {
        if (check[x]) {
            return;
        }

        check[x] = true;
        System.out.print(x + " ");
        for (int y : lists[x]) {
            if (!check[y])
                dfs(y);
        }
    }

    private static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        check[start] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");
            for (int y : lists[x]) {
                if (!check[y]) {
                    check[y] = true;
                    queue.add(y);
                }
            }
        }
    }
}
