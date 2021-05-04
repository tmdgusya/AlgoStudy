package BackjunJudge;

import java.util.*;
import java.io.*;

public class Back2751 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> set = new TreeSet<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        for(int i : set) {
            System.out.println(i);
        }

    }
}
