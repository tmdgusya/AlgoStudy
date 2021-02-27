package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex03 {

    public static void main(String[] args) {
        int N;
        String info;
        int[] trap;
        int min = 0;
        int count = 0;

        Scanner scan = new Scanner(System.in);

        N = Integer.parseInt(scan.nextLine());
        trap = new int[N];

        info = scan.nextLine();

        final String[] s = info.split(" ");
        System.out.println(Arrays.toString(s));
        for(int i = 0; i < N; i++){
            trap[i] = Integer.parseInt(s[i]);
        }

        for(int i = 0; i < 3; i++){
            Map<Integer, Integer> map = new HashMap<>();
            count = 2;
            int j = i;
            map.put(i,1);
            while(!(j + trap[j] < 0 && j + trap[j] > N)){
                j = j + trap[j];
                int value = map.getOrDefault(j, 0);
                if(value != 0) {
                    break;
                }
                map.put(j , value+1);
                count++;
            }
            if(i == 0){
                min = count;
            }
            min = Math.max(min, count);
        }

        System.out.println(min);
    }
}
