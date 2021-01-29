package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back2606 {

    static int vertax;
    static int lineCount;
    static int count = -1;

    static class Node {
        int idx;
        boolean visit;
        ArrayList<Node> nextNode;

        public Node(int idx) {
            this.idx = idx;
            this.visit = false;
            nextNode = new ArrayList<>();
        }

        void add(Node node){
            nextNode.add(node);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vertax = Integer.parseInt(br.readLine());
        lineCount = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[vertax+1];

        for(int i = 1; i<=vertax; i++){
            nodes[i] = new Node(i);
        }
        for(int i =0; i<lineCount; i++){
            StringTokenizer str = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(str.nextToken());
            int next_idx = Integer.parseInt(str.nextToken());
            nodes[idx].add(nodes[next_idx]);
            nodes[next_idx].add(nodes[idx]);
        }
        bfs(nodes[1]);
        System.out.println(count);
    }

    static void bfs(Node node){
        if(node.visit){
            return;
        }
        System.out.println("bool = " + node.visit);
        node.visit = true;
        count++;
        for (Node n : node.nextNode){
            System.out.println("idx : " + n.idx);
            bfs(n);
        }
    }
}
