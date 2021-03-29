package BackjunJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back10828 {

    public static void main(String[] args) throws IOException {
        Stack stack = new Stack();
        int n;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String command;

        for(int i = 0; i < n; i++) {
            command = br.readLine();
            if(command.startsWith("push")) {
                String[] s = command.split(" ");
                stack.push(Integer.parseInt(s[1]));
                continue;
            }
            if("size".equals(command)) {
                System.out.println(stack.size());
                continue;
            }
            if("empty".equals(command)) {
                System.out.println(stack.empty());
                continue;
            }
            if("pop".equals(command)) {
                System.out.println(stack.pop());
                continue;
            }
            if("top".equals(command)) {
                System.out.println(stack.top());
            }
        }

    }

    private static class Stack {

        Node topNode;
        int size;

        public void push(int data) {
            if(topNode == null) {
                topNode = new Node(data, null);
            }else {
                topNode = new Node(data, topNode);
            }
            size++;
        }

        public int top() {
            if(topNode == null) {
                return -1;
            }
            return topNode.data;
        }

        public int pop() {
            if(topNode == null) {
                return -1;
            }
            int data = topNode.data;
            topNode = topNode.nextNode;
            size--;
            return data;
        }

        public int size() {
            return size;
        }

        public int empty() {
            return topNode == null ? 1 : 0;
        }

        private class Node {
            final int data;
            final Node nextNode;

            public Node(int data, Node nextNode) {
                this.data = data;
                this.nextNode = nextNode;
            }
        }
    }

}
