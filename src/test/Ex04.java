package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex04 {

    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> info = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N*N; i++){
            final String[] s = br.readLine().split(" ");
            for(int j = 2; j < s.length; j++) {
                int max = Math.max(Integer.parseInt(s[1]), info.getOrDefault(Integer.parseInt(s[j]), 0));
                info.put(Integer.parseInt(s[j]), max);
            }
        }

        for(int key : info.keySet()){
            answer += info.get(key);
        }

        System.out.println(answer);
    }
}
