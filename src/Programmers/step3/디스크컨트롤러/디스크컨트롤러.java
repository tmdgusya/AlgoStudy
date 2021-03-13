package Programmers.step3.디스크컨트롤러;

import java.util.*;

public class 디스크컨트롤러 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        final int solution1 = solution.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
        System.out.println(solution1);
    }

    static class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;
            int cnt = 0;
            LinkedList<int[]> waiting = new LinkedList<>();
            PriorityQueue<int[]> workQueue
                    = new PriorityQueue<>(new Comparator<int[]> (){
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });

            for(int[] job : jobs) {
                waiting.offer(job);
            }
            Collections.sort(waiting, (o1, o2) -> {
                return o1[0] - o2[0];
            });

            int time = waiting.peek()[0];

            while(cnt < jobs.length) {
                while(!waiting.isEmpty() && waiting.peek()[0] <= time) {
                    workQueue.offer(waiting.pollFirst());
                }
                if(!workQueue.isEmpty()) {
                    int[] j = workQueue.poll();
                    time += j[1];
                    answer += time - j[0];
                    cnt++;
                } else {
                    time++;
                }
            }

            return answer / jobs.length;
        }
    }
}
