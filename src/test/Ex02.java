package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex02 {
    public static void main(String args[]) {
        String info;
        Map<String, Integer> result = new HashMap<>();

        int pcCount;
        int customer;
        int hour;
        int count = 0;

        String[] scheduler;

        Scanner sc = new Scanner(System.in);

        info = sc.nextLine();
        final String[] infoArray = info.split(" ");
        pcCount = Integer.parseInt(infoArray[0]);
        customer = Integer.parseInt(infoArray[1]);
        hour = Integer.parseInt(infoArray[2]);
        int maxTime = 0;

        scheduler = new String[customer];

        for(int i = 0; i < customer; i++){
            scheduler[i] = sc.nextLine();
        }

        for (String value : scheduler) {
            final String[] s = value.split(" ");
            if(result.getOrDefault(s[0], 0) == 0){
                result.put(s[0], 0);
            }
            if (Integer.parseInt(s[1]) <= hour) {
                if(result.getOrDefault(s[0], 0) + Integer.parseInt(s[1]) <= hour){ ;
                    maxTime = result.get(s[0]) + Integer.parseInt(s[1]);
                }else{
                    maxTime = Math.max(result.get(0), Integer.parseInt(s[1]));
                }
                result.put(s[0], maxTime);
            }
        }

        for (String key : result.keySet()) {
            System.out.print(key + " ");
            System.out.println(result.get(key) * 1000);
        }

    }
}
