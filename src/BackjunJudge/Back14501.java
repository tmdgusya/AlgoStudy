package BackjunJudge;

import java.util.Scanner;

public class Back14501 {
    static int N;
    static int[] times;
    static int[] prices;
    static int max = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        int[] times = new int[N];
        int[] prices = new int[N];

        for(int i = 0; i < N; i++){
            times[i] = scan.nextInt();
            prices[i] = scan.nextInt();
        }
        schedule(0,0);
        System.out.println(max);
    }

    static void schedule(int day ,int money){
        if(day >= N){
            max = Math.max(max, money);
        }else if(day + times[day] <= N){
            schedule(day+times[day], money+prices[day]);
        }
        schedule(day+1, money);
    }
}
