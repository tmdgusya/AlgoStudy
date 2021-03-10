package Programmers.step3.이중우선순위큐;

import java.util.*;

public class 이중우선순위큐 {

    public static void main(String[] args) {
        String[] case2 = {"I 7","I 5","I -5","D -1"};
        String[] case1 = new String[]{"I 16", "D 1"};
        String[] case3 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(case3)));
    }

    static class Solution {

        static int[] answer;

        public int[] solution(String[] operations) {
            ArrayList<Integer> list = new ArrayList<>();
            answer = new int[2];
            for(String s : operations) {
                action(list, s);
            }
            Collections.sort(list);
            if(list.size() > 0 ){
                answer[1] = list.get(0);
                list.sort((o1, o2) -> {
                    return o2 - o1;
                });
                answer[0] = list.get(0);
            }
            return answer;
        }

        public void action(List<Integer> list, String s) {
            String[] operation = s.split(" ");
            if(operation[0].equals("I")) {
                input(list, Integer.parseInt(operation[1]));
            }
            if(operation[0].equals("D") && list.size() > 0) {
                if(operation[1].equals("1")) {
                    list.sort((o1, o2) -> {return o2-o1;});
                    list.remove(0);
                }
                if(operation[1].equals("-1")) {
                    Collections.sort(list);
                    list.remove(0);
                }
            }
        }

        public void input(List<Integer> list, int num) {
            list.add(num);
        }
    }
}
