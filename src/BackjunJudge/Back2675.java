package BackjunJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2675 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            int K = Integer.parseInt(st.nextToken());
            char[] str = st.nextToken().toCharArray();
            for (char c : str) {
                sb.append(String.valueOf(c).repeat(Math.max(0, K)));
            }
            System.out.println(sb.toString());
        }
    }

}
