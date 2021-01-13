package BackjunJudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Back14501 {
    static int N;
    static int[] times;
    static int[] prices;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N =  Integer.parseInt(br.readLine());

        times = new int[N];
        prices = new int[N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            times[i] = Integer.parseInt(st.nextToken());
            prices[i] = Integer.parseInt(st.nextToken());
        }

        schedule(0,0);

        System.out.println(max);
    }

    static void schedule(int day ,int money){
        if(day >= N){
            max = Math.max(max, money);
            return;
        }
        if(day + times[day] <= N){schedule(day + times[day], money+prices[day]);}
        else schedule(day+1, money);
    }
}
