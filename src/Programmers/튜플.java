package Programmers;

import java.security.KeyStore;
import java.util.*;

public class 튜플 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString( solution.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
    }

    static class Solution {
        public int[] solution(String s) {
            Map<String, Integer> map = new HashMap<>();
            String deleteBracket = s.replaceAll("[{}]", "");
            final String[] split = deleteBracket.split(",");
            for(String a : split){
                Integer value = map.getOrDefault(a, 0);
                map.put(a, ++value);
            }

            List<Map.Entry<String, Integer>> list_entries = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
            Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>(){
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            final String split1 = list_entries.toString();
            final String[] split2 = split1.replace("[", "").replace("]", "").split(", ");
            int[] answer = new int[list_entries.size()];
            int idx = 0;
            for(String a : split2){
                answer[idx] = Integer.parseInt(a.split("=")[0]);
                idx++;
            }
            return answer;
        }
    }
}
