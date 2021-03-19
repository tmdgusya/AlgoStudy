package BackjunJudge;

import java.util.*;
import java.io.*;

public class Back2798 {

    static Set<Integer> list;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cards;
        list = new HashSet<>();
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        int index_ = 0;

        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());


        cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()) {
            cards[index_] = Integer.valueOf(st.nextToken());
            index_++;
        }

        System.out.println(searchNearValueByInputNumber(cards, M));

    }

    public static int searchNearValueByInputNumber(int[] cards, int number) {
        int result = 0;

        for(int i = 0; i < N; i++) {
            for(int j = i+1; j < N; j++) {
                for(int k = j+1; k < N; k++) {
                    int answer = cards[i] + cards[j] + cards[k];

                    if(M == answer) {
                        return answer;
                    }

                    if(result < answer && answer < M) {
                        result = answer;
                    }
                }
            }
        }
        return result;
    }

}
