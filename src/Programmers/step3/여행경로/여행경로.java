package Programmers.step3.여행경로;

import java.util.*;

public class 여행경로 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[][]{
                {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
    }

    static class Solution {

        static ArrayList<String> paths;
        static boolean[] visited;

        public String[] solution(String[][] tickets) {
            paths = new ArrayList<String>();
            visited = new boolean[tickets.length];
            dfs(tickets, "ICN", "ICN", 0);
            Collections.sort(paths);
            String[] answer = paths.get(0).split(" ");
            return answer;
        }

        public void dfs(String[][] tickets, String start, String path, int count) {
            if(count == tickets.length) {
                paths.add(path);
                return;
            }
            for(int i = 0; i < tickets.length; i++) {
                if(!visited[i] && tickets[i][0].equals(start)) {
                    visited[i] = true;
                    dfs(tickets, tickets[i][1], path + " " + tickets[i][1], count+1);
                    visited[i] = false;
                }
            }
        }
    }
}
