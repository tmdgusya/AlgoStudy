package BackjunJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back2042 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long[] array = new long[(int) N];

        for(int i = 0; i < N; i++) {
            array[i] = Long.parseLong(br.readLine());
        }

        for(int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            long C = Long.parseLong(st.nextToken());
            if(A == 1) {
                array[(int) (B-1)] = C;
            }
            if(A == 2) {
                System.out.println(sumArray(B-1, C-1, array));
            }
        }

    }

    public static int sumArray(long start, long end, long[] array) {
        int sum = 0;
        for(long i = start; i <= end; i++) {
            sum += array[(int) i];
        }
        return sum;
    }

}
