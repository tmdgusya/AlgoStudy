package BackjunJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back1175 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> map = new HashMap<>();

        char[] str = br.readLine().toUpperCase(Locale.ROOT).toCharArray();

        for(char c : str) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue());

        if(list.size() == 1) {
            System.out.println(list.get(0).getKey());
            return;
        }

        if(list.get(list.size() - 1).getValue().equals(list.get(list.size() - 2).getValue())){
            System.out.println('?');
        }else {
            System.out.println(list.get(list.size() - 1).getKey());
        }

    }

}
