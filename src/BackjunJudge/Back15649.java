package BackjunJudge;

import java.util.*;
import java.io.*;

public class Back15649 {

    static ArrayList<String> list;
    static boolean[] visited;
    static int N;
    static int M;
    static int[] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        list = new ArrayList<String>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            array[i] += (i+1);
        }

        System.out.println(Arrays.toString(array));

        for(int i = 0; i < array.length; i++) {
            dfs(array, array.length, M, "");
        }

        for(String perm : list) {
            System.out.println(perm);
        }

    }

    public static void dfs(int[] array, int n, int depth, String result) {
        if(depth == 0) {
            if(!list.contains(result)) {
                list.add(result);
            }
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(array, n, depth-1, result+array[i]+" ");
                visited[i] = false;
            }
        }
    }
}
