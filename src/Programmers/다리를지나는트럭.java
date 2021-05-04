package Programmers;

import java.util.*;

public class 다리를지나는트럭 {

    public static void main(String[] args) {

    }

    static class Solution {

        static List<Integer> going = new ArrayList<Integer>();
        static List<Integer> done = new ArrayList<Integer>();

        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;

            List<Integer> start = new ArrayList<Integer>();

            for(int i = 0; i < truck_weights.length; i++) {
                start.add(truck_weights[i]);
            }

            while(start.size() > 0) {
                Integer remove = start.remove(0);
                answer++;
            }

                return answer;
        }
    }

}
