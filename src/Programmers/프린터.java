package Programmers;
import java.util.*;

public class 프린터 {

    public static void main(String[] args) {
        int[] a = {2,1,3,2};
        final int solution = Solution.solution(a, 2);
        System.out.println(solution);
    }

    static class Solution {

        public static int solution(int[] priorities, int location) {
            if(location > priorities.length-1){
                location = priorities.length-1;
            }

            Queue<Node> printer = new LinkedList<>();

            int idx = 0;
            int answer = 1;
            for(int ele : priorities){
                printer.add(new Node(idx, ele));
                idx++;
            }

            while(true){
                int a = printer.peek().data;
                boolean action = false;
                for(Node node : printer){
                    if(node.data > a){
                        action = true;
                    }
                }
                if(action){
                    printer.offer(printer.poll());
                    continue;
                }
                if(printer.peek().idx == location){
                    break;
                }
                printer.poll();
                answer++;
            }

            return answer;
        }

        static class Node {
            int data;
            int idx;

            public Node( int idx, int data) {
                this.data = data;
                this.idx = idx;
            }
        }
    }


}
