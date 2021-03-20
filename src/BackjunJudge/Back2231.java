package BackjunJudge;

import java.io.*;
import java.util.Arrays;

public class Back2231 {

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        search(N);

        System.out.println(answer);
    }

    public static void search(int N) {

        for(int i = N/2; i <= N; i++) {
            String[] number = String.valueOf(i).split("");

            int result = i;

            for(String a : number) {
                result += Integer.parseInt(a);
            }

            if(result == N) {
                answer = i;
                return;
            }
        }
    }
}
